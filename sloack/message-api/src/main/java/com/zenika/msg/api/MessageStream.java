/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package com.zenika.msg.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.namedCall;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

import akka.NotUsed;
import akka.stream.javadsl.Source;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

/**
 * The hello stream interface.
 * <p>
 * This describes everything that Lagom needs to know about how to serve and
 * consume the HelloStream service.
 */
public interface MessageStream extends Service {

    /* TODO :Define right type below. Tips : We are exposing a stream on the last message
    * 
    * */
    ServiceCall<NotUsed, NotUsed, NotUsed> stream();

    /*
     TODO :Define right type below. Tips : The message that is coming with request containts name and message,
      *look for one special type dedicated
    * */
    ServiceCall<NotUsed, NotUsed, NotUsed> message();

    @Override
    default Descriptor descriptor() {

        return named("messageStream").with(
                namedCall("/api/messagestream", stream()),
                restCall(Method.POST, "/api/messages/", message())

        ).withAutoAcl(true);
    }
}
