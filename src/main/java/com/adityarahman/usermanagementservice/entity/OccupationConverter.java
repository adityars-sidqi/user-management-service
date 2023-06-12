package com.adityarahman.usermanagementservice.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class OccupationConverter implements AttributeConverter<Occupation, String> {
    @Override
    public String convertToDatabaseColumn(Occupation occupation) {
        if (occupation == null) {
            return null;
        }
        return occupation.getCode();
    }

    @Override
    public Occupation convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Occupation.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
