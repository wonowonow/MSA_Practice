package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.client.ProductClient;
import com.sparta.msa_exam.order.client.response.ProductResponseDto;
import com.sparta.msa_exam.order.client.response.ProductsResponse;
import com.sparta.msa_exam.order.common.exception.OrderException;
import com.sparta.msa_exam.order.common.message.ExceptionMessage;
import com.sparta.msa_exam.order.dto.OrderCreateDto;
import com.sparta.msa_exam.order.dto.OrderEditDto;
import com.sparta.msa_exam.order.dto.OrderProductCreateDto;
import com.sparta.msa_exam.order.dto.OrderResponseDto;
import com.sparta.msa_exam.order.model.Order;
import com.sparta.msa_exam.order.repository.OrderRepository;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImplV1 implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductService orderProductService;
    private final ProductClient productClient;

    @Override
    @Transactional
    public OrderResponseDto createOrder(OrderCreateDto orderCreateDto) {

        Order order = Order.of(orderCreateDto);
        order = orderRepository.save(order);

        Set<Long> products = productClient.getProducts()
                                          .getData()
                                          .stream()
                                          .map(ProductResponseDto::product_id)
                                          .collect(Collectors.toSet());

        for (Long id : orderCreateDto.product_ids()) {
            if (!products.contains(id)) {
                throw new OrderException(ExceptionMessage.NOT_FOUND_PRODUCT);
            }
            OrderProductCreateDto orderProductCreateDto = new OrderProductCreateDto(order, id);
            order.addOrderProduct(orderProductService.createOrderProduct(orderProductCreateDto));;
        }

        return OrderResponseDto.fromEntity(order);
    }

    @Override
    @Cacheable(cacheNames = "order", key = "args[0]")
    @Transactional(readOnly = true)
    public OrderResponseDto getOrder(Long orderId) {

        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new OrderException(ExceptionMessage.NOT_FOUND_ORDER)
        );

        return OrderResponseDto.fromEntity(order);
    }

    @Override
    @CachePut(cacheNames = "order", key = "args[0]")
    @Transactional
    public OrderResponseDto editOrder(Long orderId, OrderEditDto orderEditDto) {

        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new OrderException(ExceptionMessage.NOT_FOUND_ORDER)
        );

        ProductsResponse products = productClient.getProducts();

        if (products.getData().stream().noneMatch(product -> product.product_id().equals(orderEditDto.product_id()))) {
            throw new OrderException(ExceptionMessage.NOT_FOUND_PRODUCT);
        }

        order.addOrderProduct(orderProductService.createOrderProduct(new OrderProductCreateDto(order, orderEditDto.product_id())));

        return OrderResponseDto.fromEntity(order);
    }
}
