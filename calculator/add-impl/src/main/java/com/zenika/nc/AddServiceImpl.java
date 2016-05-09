package com.zenika.nc;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static java.util.concurrent.CompletableFuture.completedFuture;

/**
 * Created by fsznajderman on 04/04/2016.
 */
public class AddServiceImpl implements AddService {
    @Override
    public ServiceCall<NotUsed, NotUsed, Integer> op() {
        //return (id, operandes) -> completedFuture(operandes.getOp1() + operandes.getOp2());
        return (id, operandes) -> completedFuture(1 + 1);

    }


}
