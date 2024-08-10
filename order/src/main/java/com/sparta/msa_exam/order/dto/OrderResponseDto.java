package com.sparta.msa_exam.order.dto;

import com.sparta.msa_exam.order.model.Order;
import com.sparta.msa_exam.order.model.OrderProduct;
import java.io.Serializable;
import java.util.List;
import lombok.Builder;

@Builder
public record OrderResponseDto(
        Long order_id,
        List<Integer> product_ids
) implements Serializable {

    public static OrderResponseDto fromEntity(Order order) {
        return OrderResponseDto.builder()
                               .order_id(order.getOrderId())
                               .product_ids(order.getProductIds()
                                                 .stream()
                                                 .map(OrderProduct::getProductId)
                                                 .map(Long::intValue)
                                                 .toList())
                               .build();
    }

}
