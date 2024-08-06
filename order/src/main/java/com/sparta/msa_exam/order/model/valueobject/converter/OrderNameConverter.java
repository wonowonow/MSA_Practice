package com.sparta.msa_exam.order.model.valueobject.converter;

import com.sparta.msa_exam.order.model.valueobject.OrderName;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class OrderNameConverter implements AttributeConverter<OrderName, String> {

    @Override
    public String convertToDatabaseColumn(OrderName orderName) {

        if (orderName == null) {
            return null;
        }

        return orderName.value();
    }

    @Override
    public OrderName convertToEntityAttribute(String dbData) {

        if (dbData == null) {
            return null;
        }

        return new OrderName(dbData);
    }
}
