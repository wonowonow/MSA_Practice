package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.dto.OrderCreateDto;
import com.sparta.msa_exam.order.dto.OrderResponseDto;

public interface OrderService {

    void createOrder(OrderCreateDto order);

    OrderResponseDto getOrder(Long orderId);

    void editOrder(Long orderId);
}
