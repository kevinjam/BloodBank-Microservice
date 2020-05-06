package com.kevinjanvier.bloodbanksignupservice.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public class CreateUserCommand {
    @TargetAggregateIdentifier
    private UUID userId;
    private String name;
    private String email;
    private String userName;
    private String password;
    private String address;
    private String createdAt;
    private String modifiedAt;

    public CreateUserCommand() {
    }

    public CreateUserCommand(UUID userId, String name, String email, String userName, String password, String address) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.address = address;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }
}
