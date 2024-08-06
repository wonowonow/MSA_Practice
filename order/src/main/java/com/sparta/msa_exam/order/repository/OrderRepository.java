package com.sparta.msa_exam.order.repository;

import com.sparta.msa_exam.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}