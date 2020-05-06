package com.kevinjanvier.bloodbanksignupservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;
import java.util.UUID;

@Document("users")
public class CreateUserModel {

    @Id
    private UUID userId;
    private Map<UUID, String> users;

    public CreateUserModel(UUID userId, Map<UUID, String> users) {
        this.userId = userId;
        this.users = users;
    }

    public UUID getUserId() {
        return userId;
    }

    public Map<UUID, String> getUsers() {
        return users;
    }
}
