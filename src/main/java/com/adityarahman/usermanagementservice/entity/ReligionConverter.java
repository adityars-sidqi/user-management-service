package com.adityarahman.usermanagementservice.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class ReligionConverter implements AttributeConverter<Religion, String> {
    @Override
    public String convertToDatabaseColumn(Religion religion) {
        if (religion == null) {
            return null;
        }
        return religion.getCode();
    }

    @Override
    public Religion convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Religion.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
