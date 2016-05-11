/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package com.zenika.user.impl;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRef;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRegistry;
import com.lightbend.lagom.javadsl.pubsub.PubSubRegistry;
import com.zenika.user.api.UserInfo;
import com.zenika.user.api.UserService;
import com.zenika.user.impl.UserCommand.SignIn;
import com.zenika.user.impl.UserCommand.Users;


import javax.inject.Inject;
import java.util.List;


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
            PersistentEntityRef<UserCommand> ref = persistentEntityRegistry.refFor(User.class, ROOM_ID);
            return ref.ask((new SignIn(name)));
        };
    }

    @Override
    public ServiceCall<NotUsed, NotUsed, List<UserInfo>> users() {
        return (id, req) -> {

            PersistentEntityRef<UserCommand> ref = persistentEntityRegistry.refFor(User.class, ROOM_ID);
            return ref.ask((new Users()));
        };

    }

  /*public ServiceCall<String, NotUsed, String> hello() {
    return (id, request) -> {
      // Look up the hello world entity for the given ID.
      PersistentEntityRef<UserCommand> ref = persistentEntityRegistry.refFor(User.class, id);
      // Ask the entity the Hello command.
      return ref.ask(new Users(new ArrayList<UserInfo>()));
    };
  }


    public ServiceCall<String, UserInfo, Done> useGreeting() {
        return (id, request) -> {
            // Look up the hello world entity for the given ID.
            PersistentEntityRef<UserCommand> ref = persistentEntityRegistry.refFor(User.class, id);
            // Tell the entity to use the greeting name specified.
            return ref.ask(new SignIn(request.name));
        };

    }
    */

}
