package com.adityarahman.usermanagementservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MaritalStatus {
    BELUM_KAWIN("BK"),
    KAWIN("K"),
    CERAI_HIDUP("CH"),
    CERAI_MATI("CM");

    private final String code;
}
