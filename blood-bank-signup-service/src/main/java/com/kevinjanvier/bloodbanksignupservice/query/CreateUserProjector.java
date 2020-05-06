package com.kevinjanvier.bloodbanksignupservice.query;

import com.kevinjanvier.bloodbanksignupservice.events.UserCreatedEvent;
import com.kevinjanvier.bloodbanksignupservice.models.CreateUserModel;
import com.kevinjanvier.bloodbanksignupservice.repository.CreateUserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CreateUserProjector {
    private static final Log log = LogFactory.getLog(CreateUserProjector.class);


    private CreateUserRepository repository;

    public CreateUserProjector(CreateUserRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(UserCreatedEvent event) {
        log.info("START CREATING EVENT" + event);
        CreateUserModel users = new CreateUserModel(event.getUserId(),
                Collections.emptyMap());
        log.info("SAVE USER DETAILS" + users);
        repository.save(users);
    }

    @QueryHandler
    public CreateUserModel handle(FindUserQuery query){
        CreateUserModel getuserFromdb = repository.findById(query.getUserId()).orElse(null);
        log.info("GETTING USERS FROM DB" + getuserFromdb);
        return getuserFromdb;
    }
}
