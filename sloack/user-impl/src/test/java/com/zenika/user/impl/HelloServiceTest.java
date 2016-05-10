/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package com.zenika.user.impl;

import static com.lightbend.lagom.javadsl.testkit.ServiceTest.defaultSetup;
import static com.lightbend.lagom.javadsl.testkit.ServiceTest.withServer;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import akka.NotUsed;
import com.zenika.user.api.UserInfo;
import com.zenika.user.api.UserService;

public class HelloServiceTest {

  @Test
  public void shouldStorePersonalizedGreeting() throws Exception {
    withServer(defaultSetup(), server -> {
      UserService service = server.client(UserService.class);

      String msg1 = service.hello().invoke("Alice", NotUsed.getInstance()).toCompletableFuture().get(5, SECONDS);
      assertEquals("Hello, Alice!", msg1); // default greeting

      service.useGreeting().invoke("Alice", new UserInfo("Hi")).toCompletableFuture().get(5, SECONDS);
      String msg2 = service.hello().invoke("Alice", NotUsed.getInstance()).toCompletableFuture().get(5, SECONDS);
      assertEquals("Hi, Alice!", msg2);

      String msg3 = service.hello().invoke("Bob", NotUsed.getInstance()).toCompletableFuture().get(5, SECONDS);
      assertEquals("Hello, Bob!", msg3); // default greeting
    });
  }

}
