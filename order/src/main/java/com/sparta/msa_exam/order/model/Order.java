package com.sparta.msa_exam.order.model;

import com.sparta.msa_exam.order.dto.OrderCreateDto;
import com.sparta.msa_exam.order.model.valueobject.OrderName;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Embedded
    private OrderName name;

    @OneToMany(mappedBy = "order")
    List<OrderProduct> productIds;

    public static Order of(OrderCreateDto orderCreateDto) {

        return Order.builder()
                    .name(new OrderName(orderCreateDto.name()))
                    .productIds(new ArrayList<>())
                    .build();
    }

    // 양방향 편의성 메소드
    public void addOrderProduct(OrderProduct orderProduct) {
        this.productIds.add(orderProduct);
    }
}
