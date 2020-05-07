package com.kevinjanvier.bloodbanksignupservice.command;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public class SelectUserCommand {
    @TargetAggregateIdentifier
    private UUID uuid;
    private String userName;

    public SelectUserCommand(UUID uuid, String userName) {
        this.uuid = uuid;
        this.userName = userName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getUserName() {
        return userName;
    }
}
