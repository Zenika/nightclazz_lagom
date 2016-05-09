package com.zenika.nc;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.deser.IdSerializers;

import java.util.Arrays;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;

/**
 * Created by fsznajderman on 03/04/2016.
 */
public interface MinService extends Service {

    ServiceCall<NotUsed, Operandes, Integer> op();

    @Override
    default Descriptor descriptor() {
        return named("min")
                .with(pathCall("/api/op/min", op())).withAutoAcl(true);


    }
}
