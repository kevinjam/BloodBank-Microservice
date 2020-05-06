package com.kevinjanvier.bloodbanksignupservice.repository;

import com.kevinjanvier.bloodbanksignupservice.models.CreateUserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CreateUserRepository extends MongoRepository<CreateUserModel, UUID> {
}
