/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package com.zenika.user.impl;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRef;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRegistry;

import java.util.Optional;

import javax.inject.Inject;
import com.zenika.user.api.UserInfo;
import com.zenika.user.api.UserService;
import com.zenika.user.impl.HelloCommand.*;

/**
 * Implementation of the HelloService.
 */
public class UserServiceImpl implements UserService {

  private final PersistentEntityRegistry persistentEntityRegistry;

  @Inject
  public UserServiceImpl(PersistentEntityRegistry persistentEntityRegistry) {
    this.persistentEntityRegistry = persistentEntityRegistry;
    persistentEntityRegistry.register(HelloWorld.class);
  }

  @Override
  public ServiceCall<String, NotUsed, String> hello() {
    return (id, request) -> {
      // Look up the hello world entity for the given ID.
      PersistentEntityRef<HelloCommand> ref = persistentEntityRegistry.refFor(HelloWorld.class, id);
      // Ask the entity the Hello command.
      return ref.ask(new Hello(id, Optional.empty()));
    };
  }

  @Override
  public ServiceCall<String, UserInfo, Done> useGreeting() {
    return (id, request) -> {
      // Look up the hello world entity for the given ID.
      PersistentEntityRef<HelloCommand> ref = persistentEntityRegistry.refFor(HelloWorld.class, id);
      // Tell the entity to use the greeting name specified.
      return ref.ask(new UseGreetingMessage(request.name));
    };

  }

}
