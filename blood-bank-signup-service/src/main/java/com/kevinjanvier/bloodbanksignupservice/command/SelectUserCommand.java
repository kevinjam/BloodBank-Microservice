package com.kevinjanvier.bloodbanksignupservice.command;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public class SelectUserCommand {
    @TargetAggregateIdentifier
    private UUID userId;
    private String userName;

    public SelectUserCommand(UUID userId, String userName) {
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
