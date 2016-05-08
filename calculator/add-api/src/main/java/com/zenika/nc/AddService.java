package com.zenika.nc;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.namedCall;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;

/**
 * Created by fsznajderman on 03/04/2016.
 */
public interface AddService extends Service {

    ServiceCall<NotUsed, Operandes, Integer> addOp();

    ServiceCall<NotUsed, NotUsed, String> hello();

    @Override
    default Descriptor descriptor() {
        return named("add")
                .with(
                        pathCall("/api/op/add/", addOp()),
                        namedCall("/api/hello", hello())
                ).withAutoAcl(true);


    }
}
