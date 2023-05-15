package com.codingbox.planner.domain.enums;

public enum Role {
    ROLE_USER("유저"), ROLE_MANAGER("매니저"), ROLE_ADMIN("관리자");

    private final String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
