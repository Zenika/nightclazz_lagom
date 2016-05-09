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
public interface DivService extends Service {

    ServiceCall< NotUsed,Operandes, Integer> op();

    @Override
    default Descriptor descriptor() {
        return named("div")
                .with(pathCall("/api/op/div", op())).withAutoAcl(true);


    }
}
