package com.adityarahman.usermanagementservice.entity;

public enum Gender {
    MALE("M"), FEMALE("F");

    private final String code;

    Gender(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
