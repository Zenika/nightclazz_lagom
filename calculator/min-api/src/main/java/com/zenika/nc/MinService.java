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

    ServiceCall<Operandes, NotUsed, Integer> addOp();

    @Override
    default Descriptor descriptor() {
        return named("min")
                .with(pathCall("/api/op/:op1/min/:op2", addOp()))
                .with(Operandes.class, IdSerializers.create("Operandes", Operandes::of, (Operandes id) -> {
                    return Arrays.asList(id.getOp1(), id.getOp2());
                })).withAutoAcl(true);


    }
}
