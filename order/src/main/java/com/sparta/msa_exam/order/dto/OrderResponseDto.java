package com.sparta.msa_exam.order.dto;

import java.util.List;

public record OrderResponseDto(
        Long order_id,
        List<Integer> product_ids
) {

}
