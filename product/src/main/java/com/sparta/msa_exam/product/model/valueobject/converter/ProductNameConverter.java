package com.sparta.msa_exam.product.model.valueobject.converter;

import com.sparta.msa_exam.product.model.valueobject.ProductName;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ProductNameConverter implements AttributeConverter<ProductName, String> {

    @Override
    public String convertToDatabaseColumn(ProductName productName) {

        if (productName == null) {
            return null;
        }

        return productName.value();
    }

    @Override
    public ProductName convertToEntityAttribute(String dbData) {

        if (dbData == null) {
            return null;
        }

        return new ProductName(dbData);
    }
}
