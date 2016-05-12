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
    public ServiceCall<NotUsed, NotUsed, NotUsed> hello() {
        return
                /*
                 *  Todo :
                 *  Fill the right type for id and response
                 *  write the right lambda that matches with ServiceCall invoke() method.
                 *  TIPS :
                 *      - lambda above must return one subtype of CompletionStage<Response>, look at serviceCall interface source code
                 *      - it is here that the returned message will be formatted
                 */
    }


}
