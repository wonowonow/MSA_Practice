package com.sparta.msa_exam.order.dto;

import com.sparta.msa_exam.order.model.Order;

public record OrderProductCreateDto (
        Order order,
        Long productId
){

}
