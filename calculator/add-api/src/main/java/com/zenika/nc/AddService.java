package com.zenika.nc;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.namedCall;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

/**
 * Created by fsznajderman on 03/04/2016.
 */
public interface AddService extends Service {

    //ServiceCall<NotUsed, Operandes, Integer> op();
    ServiceCall<NotUsed, Operandes, Integer> op();

    @Override
    default Descriptor descriptor() {
        return named("add").with(pathCall("/api/op/add", op())).withAutoAcl(true);


    }
}
