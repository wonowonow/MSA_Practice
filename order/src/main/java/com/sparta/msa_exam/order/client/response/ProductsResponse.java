package com.sparta.msa_exam.order.client.response;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class ProductsResponse extends CommonResponseData {

    private final List<ProductResponseDto> data;

    public ProductsResponse(boolean success, String message, ArrayList<ProductResponseDto> data) {
        super(success, message);
        this.data = data;
    }

}
