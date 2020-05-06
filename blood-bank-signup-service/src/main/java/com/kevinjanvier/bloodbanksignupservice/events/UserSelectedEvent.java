package com.kevinjanvier.bloodbanksignupservice.events;


import java.util.UUID;

public class UserSelectedEvent {
    private UUID userId;
    private String userName;

    public UserSelectedEvent(UUID userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
