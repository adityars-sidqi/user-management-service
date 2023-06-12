package com.adityarahman.usermanagementservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Religion {
    ISLAM("I"),
    KATOLIK("K"),
    PROTESTAN("P"),
    HINDU("H"),
    BUDDHA("B"),
    KHONGHUCU("KH");

    private final String code;
}
