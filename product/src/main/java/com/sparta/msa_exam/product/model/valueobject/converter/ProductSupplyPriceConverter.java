package com.sparta.msa_exam.product.model.valueobject.converter;

import com.sparta.msa_exam.product.model.valueobject.ProductSupplyPrice;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ProductSupplyPriceConverter implements AttributeConverter<ProductSupplyPrice, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ProductSupplyPrice productSupplyPrice) {

        if (productSupplyPrice == null) {
            return null;
        }

        return productSupplyPrice.value();
    }

    @Override
    public ProductSupplyPrice convertToEntityAttribute(Integer dbData) {

        if (dbData == null) {
            return null;
        }

        return new ProductSupplyPrice(dbData);
    }
}
