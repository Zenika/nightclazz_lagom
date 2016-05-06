package com.zenika.nc;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static java.util.concurrent.CompletableFuture.completedFuture;

/**
 * Created by fsznajderman on 04/04/2016.
 */
public class DispatcherServiceImpl implements DispatcherService {
    @Override
    public ServiceCall<Operandes, NotUsed, Integer> addOp() {
        return (id, name) -> {
            System.out.println("name " + name);
            return completedFuture(id.getOp1() + id.getOp2());
        };
    }
}
