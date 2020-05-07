package com.kevinjanvier.bloodbanksignupservice.commandHandler;

import com.kevinjanvier.bloodbanksignupservice.events.UserCreatedEvent;
import com.kevinjanvier.bloodbanksignupservice.exceptions.UserException;
import com.kevinjanvier.bloodbanksignupservice.models.CreateUserModel;
import com.kevinjanvier.bloodbanksignupservice.query.FindUserQuery;
import com.kevinjanvier.bloodbanksignupservice.repository.CreateUserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
public class CreateUserHandler {
    private static final Log log = LogFactory.getLog(CreateUserHandler.class);

    @Autowired
    private CreateUserRepository repository;

    @EventHandler
    public void on(UserCreatedEvent event) throws UserException {
        log.info("START CREATING EVENT" + event);
        CreateUserModel users = new CreateUserModel(event.getUuid(),event.getName(),
                event.getEmail(),event.getUsername(),event.getPassword(),event.getAddress(),event.getCreatedAt(),event.getModifiedAt());
        if (users!= null) {
            log.info("SAVING USER DETAILS" + users);
            repository.save(users);
        }else {
            throw new UserException("Model is empty");
        }

    }

    @QueryHandler
    public CreateUserModel handle(FindUserQuery query){
        CreateUserModel getUsers = repository.findById(query.getUuid()).orElse(null);
        log.info("GETTING USERS FROM DB" + getUsers);
        return getUsers;
    }

}
