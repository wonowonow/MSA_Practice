package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.dto.OrderCreateDto;
import com.sparta.msa_exam.order.dto.OrderEditDto;
import com.sparta.msa_exam.order.dto.OrderResponseDto;

public interface OrderService {

    OrderResponseDto createOrder(OrderCreateDto order);

    OrderResponseDto getOrder(Long orderId);

    OrderResponseDto editOrder(Long orderId, OrderEditDto orderEditDto);
}
