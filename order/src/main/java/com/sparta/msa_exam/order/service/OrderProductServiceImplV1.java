package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.dto.OrderProductCreateDto;
import com.sparta.msa_exam.order.repository.OrderProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProductServiceImplV1 implements OrderProductService {

    private final OrderProductRepository orderProductRepository;

    @Override
    public void createOrderProduct(OrderProductCreateDto orderProductCreateDto) {

    }
}
