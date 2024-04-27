package com.york.easyboot.pojo.dto;

public record RUserDTO(String username, String photoUrl) {
    public RUserDTO {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("username is null or empty");
        }
        if (photoUrl == null || photoUrl.isBlank()) {
            throw new IllegalArgumentException("photoUrl is null or empty");
        }
    }
}
