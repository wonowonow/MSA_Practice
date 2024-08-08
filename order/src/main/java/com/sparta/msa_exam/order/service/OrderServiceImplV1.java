package com.sparta.msa_exam.order.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.msa_exam.order.client.ProductClient;
import com.sparta.msa_exam.order.common.exception.OrderException;
import com.sparta.msa_exam.order.common.message.ExceptionMessage;
import com.sparta.msa_exam.order.dto.OrderCreateDto;
import com.sparta.msa_exam.order.dto.OrderEditDto;
import com.sparta.msa_exam.order.dto.OrderProductCreateDto;
import com.sparta.msa_exam.order.dto.OrderResponseDto;
import com.sparta.msa_exam.order.model.Order;
import com.sparta.msa_exam.order.model.OrderProduct;
import com.sparta.msa_exam.order.repository.OrderRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImplV1 implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductService orderProductService;
    private final ProductClient productClient;

    @Override
    @Transactional
    public void createOrder(OrderCreateDto orderCreateDto)
            throws ParseException, JsonProcessingException {

        Order order = Order.of(orderCreateDto);
        orderRepository.save(order);

        Set<Long> productIds = new HashSet<>();

        String products = productClient.getProducts();
        JSONParser jsonParser = new JSONParser();
        JSONObject parsedJson = (JSONObject) jsonParser.parse(products);
        JSONArray jsonArray = (JSONArray) parsedJson.get("data");

        ObjectMapper objectMapper = new ObjectMapper();
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            String productIdStr = jsonObject.get("productId").toString();
            Long productId = objectMapper.readValue(productIdStr, Long.class);
            productIds.add(productId);
        }

        for (Long id : orderCreateDto.product_ids()) {
            if (!productIds.contains(id)) {
                throw new OrderException(ExceptionMessage.NOT_FOUND_PRODUCT);
            }
            OrderProductCreateDto orderProductCreateDto = new OrderProductCreateDto(order, id);
            order.addOrderProduct(orderProductService.createOrderProduct(orderProductCreateDto));;
        }
    }

    @Override
    public OrderResponseDto getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new OrderException(ExceptionMessage.NOT_FOUND_ORDER)
        );

        List<Integer> productIds = order.getProductIds().stream()
                .map(OrderProduct::getId)
                .map(Long::intValue)
                .collect(Collectors.toList());

        return new OrderResponseDto(order.getOrderId(), productIds);
    }

    @Override
    public void editOrder(Long orderId, OrderEditDto orderEditDto)
            throws JsonProcessingException, ParseException {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new OrderException(ExceptionMessage.NOT_FOUND_ORDER)
        );

        Set<Long> productIds = new HashSet<>();

        String products = productClient.getProducts();
        JSONParser jsonParser = new JSONParser();
        JSONObject parsedJson = (JSONObject) jsonParser.parse(products);
        JSONArray jsonArray = (JSONArray) parsedJson.get("data");

        ObjectMapper objectMapper = new ObjectMapper();
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            String productIdStr = jsonObject.get("productId").toString();
            Long productId = objectMapper.readValue(productIdStr, Long.class);
            productIds.add(productId);
        }

        if (!productIds.contains(orderEditDto.product_id())) {
            throw new OrderException(ExceptionMessage.NOT_FOUND_PRODUCT);
        }

        order.addOrderProduct(orderProductService.createOrderProduct(new OrderProductCreateDto(order, orderEditDto.product_id())));
    }
}
