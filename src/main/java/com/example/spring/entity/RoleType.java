package com.example.spring.entity;

public enum RoleType {
    ADMIN(0), USER(1);

    int value;

    RoleType(int value) {
        this.value = value;
    }
}
