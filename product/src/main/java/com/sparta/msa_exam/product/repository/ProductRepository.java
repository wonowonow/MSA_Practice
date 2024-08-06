package com.sparta.msa_exam.product.repository;

import com.sparta.msa_exam.product.dto.ProductResponseDto;
import com.sparta.msa_exam.product.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new com.sparta.msa_exam.product.dto.ProductResponseDto(p.id, p.name.value, p.supplyPrice.value) "
            + "From Product p")
    List<ProductResponseDto> getProductResponses();
}
