package com.kevinjanvier.bloodbanksignupservice.models;

import com.kevinjanvier.bloodbanksignupservice.utility.Utils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

@Document("users")
public class CreateUserModel {

    @Id
    private UUID uuid;
    private String name;
    private String email;
    private String username;
    private String password;
    private String address;
    private LocalDate createdAt;
    private LocalDate modifiedAt;

    public CreateUserModel(
            UUID uuid,
                           String name,
                           String email,
                           String username,
                           String password,
                           String address,
                           LocalDate createdAt,
                           LocalDate modifiedAt) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.address = address;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getModifiedAt() {
        return modifiedAt;
    }

    @Override
    public String toString() {
        return Utils.prettyJson.toJson(this);
    }
}
