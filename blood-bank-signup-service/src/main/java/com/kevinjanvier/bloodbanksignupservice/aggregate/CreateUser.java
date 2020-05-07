package com.kevinjanvier.bloodbanksignupservice.aggregate;

import com.kevinjanvier.bloodbanksignupservice.command.CreateUserCommand;
import com.kevinjanvier.bloodbanksignupservice.command.SelectUserCommand;
import com.kevinjanvier.bloodbanksignupservice.events.UserConfirmedEvent;
import com.kevinjanvier.bloodbanksignupservice.events.UserCreatedEvent;
import com.kevinjanvier.bloodbanksignupservice.events.UserSelectedEvent;
import com.kevinjanvier.bloodbanksignupservice.exceptions.UserException;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Aggregate
public class CreateUser {

    @AggregateIdentifier
    private UUID uuid;
    private Map<UUID, String> selectedUser;
    boolean active;
    private static final Log log = LogFactory.getLog(CreateUser.class);


    public CreateUser() {
    }

    @CommandHandler
    public CreateUser(CreateUserCommand command){
        UUID aggregateId = UUID.randomUUID();
        log.info("create user command aggregate ID " + aggregateId);
        AggregateLifecycle.apply(new UserCreatedEvent(aggregateId, command.getName(),command.getEmail(), command.getUsername(),
                command.getPassword(), command.getAddress(), active,LocalDate.now(),LocalDate.now()));
    }

    @CommandHandler
    public void handle(SelectUserCommand command) throws UserException {
        if (!selectedUser.containsKey(command.getUuid())){
            throw new UserException("");
        }
        AggregateLifecycle.apply(new UserSelectedEvent(uuid, command.getUserName()));
        log.info("Handle Selected command " + command);
    }

    @EventSourcingHandler
    public void on(UserCreatedEvent event){
         uuid = event.getUuid();
         selectedUser = new HashMap<>();
        log.info("handle usercreated event ---  " + event);

    }

    @EventSourcingHandler
    public void on(UserSelectedEvent event){
        selectedUser.merge(event.getUserId(), event.getUserName(),String::concat);
    }

    @EventSourcingHandler
    public void on(UserConfirmedEvent event){
        log.info("------User Confirm event " + event);
     active = true;
    }
}
