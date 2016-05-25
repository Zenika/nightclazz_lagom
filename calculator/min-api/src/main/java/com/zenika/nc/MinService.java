package com.zenika.nc;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.named;

/**
 * Created by fsznajderman on 03/04/2016.
 */
public interface MinService extends Service {

    ServiceCall<Operandes, Integer> op();

    @Override
    default Descriptor descriptor() {
        return named("min")
                .with(Service.pathCall("/api/op/min", this::op)).withAutoAcl(true);


    }
}
