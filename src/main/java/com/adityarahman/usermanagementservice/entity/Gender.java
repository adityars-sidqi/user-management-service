package com.adityarahman.usermanagementservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {
    MALE('M'), FEMALE('F');

    private final char code;
}
