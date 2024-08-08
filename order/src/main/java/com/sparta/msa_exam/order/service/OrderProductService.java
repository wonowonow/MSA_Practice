package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.dto.OrderProductCreateDto;
import com.sparta.msa_exam.order.model.OrderProduct;

public interface OrderProductService {
    // 수정 될 수도 있음
    OrderProduct createOrderProduct(OrderProductCreateDto orderProductCreateDto);
}
