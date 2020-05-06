package com.kevinjanvier.bloodbanksignupservice.aggregate;

import com.kevinjanvier.bloodbanksignupservice.command.CreateUserCommand;
import com.kevinjanvier.bloodbanksignupservice.command.SelectUserCommand;
import com.kevinjanvier.bloodbanksignupservice.events.UserConfirmedEvent;
import com.kevinjanvier.bloodbanksignupservice.events.UserCreatedEvent;
import com.kevinjanvier.bloodbanksignupservice.events.UserSelectedEvent;
import com.kevinjanvier.bloodbanksignupservice.exceptions.UserException;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Aggregate
public class CreateUser {

    @AggregateIdentifier
    private UUID userId;

    private Map<UUID, String> selectedUser;
    boolean confirmed;


    public CreateUser() {
    }

    @CommandHandler
    public CreateUser(CreateUserCommand command){
        UUID aggregateId = UUID.randomUUID();
        AggregateLifecycle.apply(new UserCreatedEvent(aggregateId));
    }

    @CommandHandler
    public void handle(SelectUserCommand command) throws UserException {
        if (!selectedUser.containsKey(command.getUserId())){
            throw new UserException();
        }
        AggregateLifecycle.apply(new UserSelectedEvent(userId, command.getUserName()));
    }

    @EventSourcingHandler
    public void on(UserCreatedEvent event){
         userId = event.getUserId();
         selectedUser = new HashMap<>();
    }

    @EventSourcingHandler
    public void on(UserSelectedEvent event){
        selectedUser.merge(event.getUserId(), event.getUserName(),String::concat);
    }

    @EventSourcingHandler
    public void on(UserConfirmedEvent event){
     confirmed = true;
    }
}
