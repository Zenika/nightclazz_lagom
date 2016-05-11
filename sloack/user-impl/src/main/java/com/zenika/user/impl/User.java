/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package com.zenika.user.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;
import com.lightbend.lagom.javadsl.persistence.PersistentEntity;

import akka.Done;
import com.zenika.user.api.UserInfo;
import com.zenika.user.impl.UserEvent.UserSigned;

/**
 * This is an event sourced entity. It has a state, {@link UsersState}, which
 * stores what the greeting should be (eg, "Hello").
 * <p>
 * Event sourced entities are interacted with by sending them commands. This
 * entity supports two commands, a {@link UserCommand.SignIn} command, which is
 * used to change the greeting, and a {@link UserCommand.Users} command, which is a read
 * only command which returns a greeting to the name specified by the command.
 * <p>
 * Commands get translated to events, and it's the events that get persisted by
 * the entity. Each event will have an event handler registered for it, and an
 * event handler simply applies an event to the current state. This will be done
 * when the event is first created, and it will also be done when the entity is
 * loaded from the database - each event will be replayed to recreate the state
 * of the entity.
 * <p>
 * This entity defines one event, the {@link UserSigned} event,
 * which is emitted when a {@link UserCommand.SignIn} command is received.
 */
public class User extends PersistentEntity<UserCommand, UserEvent, UsersState> {

    /**
     * An entity can define different behaviours for different states, but it will
     * always start with an initial behaviour. This entity only has one behaviour.
     */
    @Override
    public Behavior initialBehavior(Optional<UsersState> snapshotState) {

    /*
     * Behaviour is defined using a behaviour builder. The behaviour builder
     * starts with a state, if this entity supports snapshotting (an
     * optimisation that allows the state itself to be persisted to combine many
     * events into one), then the passed in snapshotState may have a value that
     * can be used.
     *
     * Otherwise, the default state is to use the Hello greeting.
     */
        BehaviorBuilder b = newBehaviorBuilder(
                snapshotState.orElse(new UsersState(UsersList.builder().build(), LocalDateTime.now().toString())));

    /*
     * Command handler for the UseGreetingMessage command.
     */
        b.setCommandHandler(
                UserCommand.SignIn.class,
                // In response to this command, we want to first persist it as a
                (cmd, ctx) -> ctx.thenPersist(new UserSigned(cmd.name), evt -> ctx.reply(Done.getInstance())));

    /*
     * Event handler for the UserSigned event.
     */
        b.setEventHandler(
                UserSigned.class,
                evt -> {


                    final List<UserInfo> newList = Lists.newArrayList(UserInfo.of(evt.name));
                    newList.addAll(state().users.getUsers());


                    final UsersList newState = UsersList.of(newList);
                    return new UsersState(newState, LocalDateTime.now().toString());
                });

    /*
     * Command handler for the USer command.
     */
        b.setReadOnlyCommandHandler(UserCommand.Users.class,
                (cmd, ctx) -> ctx.reply(state().users.getUsers()));

    /*
     * We've defined all our behaviour, so build and return it.
     */
        return b.build();
    }


}
