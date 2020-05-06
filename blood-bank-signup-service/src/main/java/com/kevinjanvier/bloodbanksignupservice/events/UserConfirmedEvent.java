package com.kevinjanvier.bloodbanksignupservice.events;

import java.util.UUID;

public class UserConfirmedEvent {
    private UUID userId;

    public UserConfirmedEvent(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }
}
