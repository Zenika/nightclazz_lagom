/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package com.zenika.user.impl;

import akka.Done;
import akka.NotUsed;
import akka.stream.javadsl.Source;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRef;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRegistry;
import com.lightbend.lagom.javadsl.pubsub.PubSubRef;
import com.lightbend.lagom.javadsl.pubsub.PubSubRegistry;
import com.lightbend.lagom.javadsl.pubsub.TopicId;
import com.zenika.user.api.UserInfo;
import com.zenika.user.api.UserService;
import com.zenika.user.impl.UserCommand.SignIn;
import com.zenika.user.impl.UserCommand.Users;


import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletableFuture;


/**
 * Implementation of the HelloService.
 */
public class UserServiceImpl implements UserService {


    private static final String ROOM_ID = "mainRoom";
    private final PersistentEntityRegistry persistentEntityRegistry;


    @Inject
    public UserServiceImpl(PersistentEntityRegistry persistentEntityRegistry) {
        this.persistentEntityRegistry = persistentEntityRegistry;
        persistentEntityRegistry.register(User.class);
        /*TODO Add PubSubRegistry to manage publish subscribe*/
    }

    @Override
    public ServiceCall<String, NotUsed, Done> signin() {

        return (name, req) -> {
            PersistentEntityRef<UserCommand> refPersistance = persistentEntityRegistry.refFor(User.class, ROOM_ID);
           /*TODO : publish new user that just signed in*/

            return refPersistance.ask((new SignIn(name)));
        };
    }

    @Override
    public ServiceCall<NotUsed, NotUsed, NotUsed> users() {
        return (id, req) -> {

            PersistentEntityRef<UserCommand> ref = persistentEntityRegistry.refFor(User.class, ROOM_ID);
            return ref.ask((new Users()));
        };

    }

    @Override
    public ServiceCall<NotUsed, NotUsed, NotUsed> stream() {
        return (id,name) -> {
            /* TODO : Send to all subscriber data*/

        };
    }


}
