package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.dto.OrderProductCreateDto;
import com.sparta.msa_exam.order.model.OrderProduct;
import com.sparta.msa_exam.order.repository.OrderProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderProductServiceImplV1 implements OrderProductService {

    private final OrderProductRepository orderProductRepository;

    @Override
    @Transactional
    public OrderProduct createOrderProduct(OrderProductCreateDto orderProductCreateDto) {

        return orderProductRepository.save(OrderProduct.of(orderProductCreateDto));
    }
}
