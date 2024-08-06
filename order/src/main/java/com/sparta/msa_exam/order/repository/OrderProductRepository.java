package com.sparta.msa_exam.order.repository;

import com.sparta.msa_exam.order.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}
