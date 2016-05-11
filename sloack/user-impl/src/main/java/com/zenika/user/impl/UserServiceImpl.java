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
    private final PubSubRegistry pubSubRegistry;

    @Inject
    public UserServiceImpl(PersistentEntityRegistry persistentEntityRegistry, PubSubRegistry pubSubRegistry) {
        this.persistentEntityRegistry = persistentEntityRegistry;
        persistentEntityRegistry.register(User.class);
        this.pubSubRegistry = pubSubRegistry;
    }

    @Override
    public ServiceCall<String, NotUsed, Done> signin() {

        return (name, req) -> {
            PersistentEntityRef<UserCommand> refPersistance = persistentEntityRegistry.refFor(User.class, ROOM_ID);
            PubSubRef<String> pubsub = pubSubRegistry.refFor(TopicId.of(String.class, ROOM_ID));
            pubsub.publish(name);
            return refPersistance.ask((new SignIn(name)));
        };
    }

    @Override
    public ServiceCall<NotUsed, NotUsed, List<UserInfo>> users() {
        return (id, req) -> {

            PersistentEntityRef<UserCommand> ref = persistentEntityRegistry.refFor(User.class, ROOM_ID);
            return ref.ask((new Users()));
        };

    }

    @Override
    public ServiceCall<NotUsed, NotUsed, Source<String, NotUsed>> stream() {
        return (id,name) -> {
            System.out.println("get");
            PubSubRef<String> pubsub = pubSubRegistry.refFor(TopicId.of(String.class, ROOM_ID));
            return CompletableFuture.completedFuture(pubsub.subscriber());
        };
    }


}
