/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package com.zenika.helloworld.impl;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.zenika.helloworld.api.HelloService;

import java.util.concurrent.CompletableFuture;

/**
 * Implementation of the HelloService.
 */
public class HelloServiceImpl implements HelloService {


    @Override
    public ServiceCall<String, NotUsed, String> hello() {
        return (id, request) -> CompletableFuture.completedFuture("Hello, " + id + "!");
    }


}
