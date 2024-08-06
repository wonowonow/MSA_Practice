package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.dto.OrderProductCreateDto;

public interface OrderProductService {
    // 수정 될 수도 있음
    void createOrderProduct(OrderProductCreateDto orderProductCreateDto);
}
