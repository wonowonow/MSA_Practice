package com.sparta.msa_exam.order.dto;

import java.util.List;

public record OrderCreateDto(
        String name,
        List<Long> product_ids
) {

}
