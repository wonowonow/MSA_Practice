package com.sparta.msa_exam.order.controller;

import static com.sparta.msa_exam.order.common.message.SuccessMessage.SUCCESS_CREATE_ORDER;
import static com.sparta.msa_exam.order.common.message.SuccessMessage.SUCCESS_EDIT_ORDER;
import static com.sparta.msa_exam.order.common.message.SuccessMessage.SUCCESS_GET_ORDER;
import static com.sparta.msa_exam.order.common.response.SuccessResponse.success;

import com.sparta.msa_exam.order.common.response.CommonResponse;
import com.sparta.msa_exam.order.dto.OrderCreateDto;
import com.sparta.msa_exam.order.dto.OrderEditDto;
import com.sparta.msa_exam.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<? extends CommonResponse> createOrder(
            @RequestBody OrderCreateDto orderCreateDto
    ) {

        return ResponseEntity.status(SUCCESS_CREATE_ORDER.getHttpStatus())
                .body(success(SUCCESS_CREATE_ORDER.getMessage(), orderService.createOrder(orderCreateDto)));
    }

    @PutMapping("/order/{orderId}")
    public ResponseEntity<? extends CommonResponse> editOrder(
            @PathVariable("orderId") Long orderId, @RequestBody OrderEditDto orderEditDto
    ) {

        return ResponseEntity.status(SUCCESS_EDIT_ORDER.getHttpStatus())
                .body(success(SUCCESS_EDIT_ORDER.getMessage(), orderService.editOrder(orderId, orderEditDto)));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<? extends CommonResponse> getOrder(@PathVariable("orderId") Long orderId) {

        return ResponseEntity.status(SUCCESS_GET_ORDER.getHttpStatus())
                .body(success(SUCCESS_GET_ORDER.getMessage(), orderService.getOrder(orderId)));
    }
}
