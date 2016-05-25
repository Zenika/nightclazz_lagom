package com.zenika.nc;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static java.util.concurrent.CompletableFuture.completedFuture;

/**
 * Created by fsznajderman on 04/04/2016.
 */
public class MultServiceImpl implements MultService {
    @Override
    public ServiceCall<Operandes, Integer> op() {
        return (operandes) -> completedFuture(operandes.getOp1() * operandes.getOp2());

    }
}
