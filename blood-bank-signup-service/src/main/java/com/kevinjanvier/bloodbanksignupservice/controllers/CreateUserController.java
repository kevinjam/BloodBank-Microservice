package com.kevinjanvier.bloodbanksignupservice.controllers;

import com.kevinjanvier.bloodbanksignupservice.command.CreateUserCommand;
import com.kevinjanvier.bloodbanksignupservice.models.CreateUserModel;
import com.kevinjanvier.bloodbanksignupservice.query.FindUserQuery;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;


@RestController
public class CreateUserController {
    private static final Log log = LogFactory.getLog(CreateUserController.class);

    private final CommandGateway commandGateway;

    private final QueryGateway queryGateway;

    private final EventStore eventStore;

    public CreateUserController(CommandGateway commandGateway, QueryGateway queryGateway, EventStore eventStore) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
        this.eventStore = eventStore;
    }


    @PostMapping("/create")
    public void handle() {
        log.info("starting creating");
        commandGateway.send(new CreateUserCommand(UUID.randomUUID(), "kevin", "kevin@gmail.com", "kevin",
                "12345", "kampala", false, LocalDate.now(), LocalDate.now()));
    }

    @GetMapping("/users/{userId}")
    public CompletableFuture<CreateUserModel> handle(@PathVariable("userId") String userId) {

        CompletableFuture<CreateUserModel> query = queryGateway.query(new FindUserQuery(UUID.fromString(userId)),
                ResponseTypes.instanceOf(CreateUserModel.class));
        log.info("QUERY ----- " + query);
        return query;
    }

    @GetMapping("users")
    public Future<List<CreateUserModel>> getAllUsers() {
        throw new UnsupportedOperationException("Not implemented Yet");
    }

}
