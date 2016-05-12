/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package com.zenika.user.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;
import static com.lightbend.lagom.javadsl.api.Service.namedCall;

import akka.Done;
import akka.NotUsed;
import akka.stream.javadsl.Source;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

import java.util.List;


public interface UserService extends Service {


    /*TODO : Define right type below. Tips : we are using only id in the path*/
    ServiceCall<NotUsed, NotUsed, Done> signin();

    /*TODO : Define right type below. Tips : We are exposing a Users List by traditionnal GET query*/
    ServiceCall<NotUsed, NotUsed, NotUsed> users();

    /*TODO :Define right type below. Tips : We are exposing a stream on the last user that has been signed in*/
    ServiceCall<NotUsed, NotUsed, NotUsed> stream();

    @Override
    default Descriptor descriptor() {

        return named("userService").with(
                restCall(Method.POST, "/api/users/signin/:id", signin()),
                restCall(Method.GET, "/api/users", users()),
                namedCall("/api/usersstream", stream())
        ).withAutoAcl(true);

    }

}
