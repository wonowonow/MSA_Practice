package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.dto.OrderCreateDto;
import com.sparta.msa_exam.order.dto.OrderResponseDto;
import com.sparta.msa_exam.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImplV1 implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void createOrder(OrderCreateDto order) {

    }

    @Override
    public OrderResponseDto getOrder(Long orderId) {
        return null;
    }

    @Override
    public void editOrder(Long orderId) {

    }
}
