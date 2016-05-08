package com.zenika.nc;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static java.util.concurrent.CompletableFuture.completedFuture;

/**
 * Created by fsznajderman on 04/04/2016.
 */
public class AddServiceImpl implements AddService {
    @Override
    public ServiceCall<NotUsed, Operandes, Integer> addOp() {
        return (id, operandes) -> {
            System.out.println("name " + operandes.toString());
            return completedFuture(operandes.getOp1() + operandes.getOp2());
        };
    }

    @Override
    public ServiceCall<NotUsed, NotUsed, String> hello() {
        return (id, operandes) -> completedFuture("Hello");
    }
}
