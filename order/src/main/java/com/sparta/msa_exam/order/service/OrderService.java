package com.sparta.msa_exam.order.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.msa_exam.order.dto.OrderCreateDto;
import com.sparta.msa_exam.order.dto.OrderEditDto;
import com.sparta.msa_exam.order.dto.OrderResponseDto;
import org.json.simple.parser.ParseException;

public interface OrderService {

    void createOrder(OrderCreateDto order) throws ParseException, JsonProcessingException;

    OrderResponseDto getOrder(Long orderId);

    void editOrder(Long orderId, OrderEditDto orderEditDto)
            throws JsonProcessingException, ParseException;
}
