package com.kevinjanvier.bloodbanksignupservice.query;

import java.util.UUID;

public class FindUserQuery {
    private UUID uuid;



    public FindUserQuery(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }
}
