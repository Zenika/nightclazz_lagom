package com.zenika.nc;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import java.util.Arrays;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;

/**
 * Created by fsznajderman on 03/04/2016.
 */
public interface DispatcherService extends Service {

    ServiceCall<Operandes, Integer> compute(String id);

    @Override
    default Descriptor descriptor() {
        return named("dispatcher")
                .with(Service.pathCall("/api/calculator/:op", this::compute)).withAutoAcl(true);
    }
}
