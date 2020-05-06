package com.kevinjanvier.bloodbanksignupservice.query;

import java.util.UUID;

public class FindUserQuery {
    private UUID userId;

    public FindUserQuery(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }
}
