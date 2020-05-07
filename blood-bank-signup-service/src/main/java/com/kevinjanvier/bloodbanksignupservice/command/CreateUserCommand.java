package com.kevinjanvier.bloodbanksignupservice.command;

import org.axonframework.commandhandling.RoutingKey;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;
import java.util.UUID;

public class CreateUserCommand {

    @RoutingKey
    @TargetAggregateIdentifier
    private UUID uuid;
    private String name;
    private String email;
    private String username;
    private String password;
    private String address;
    private boolean active;
    private LocalDate createdAt;
    private LocalDate modifiedAt;


    public CreateUserCommand(UUID uuid, String name,
                             String email,
                             String username, String password,
                             String address, boolean active,LocalDate createdAt,
                             LocalDate modifiedAt) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.address = address;
        this.active = active;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getModifiedAt() {
        return modifiedAt;
    }
}
