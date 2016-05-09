package com.zenika.nc;

import akka.NotUsed;
import com.google.inject.Inject;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.ServiceLocator;
import play.libs.ws.WSClient;


/**
 * Created by fsznajderman on 04/04/2016.
 */
public class DispatcherServiceImpl implements DispatcherService {

    final AddService addService;

    @Inject
    public DispatcherServiceImpl(AddService add) {
        this.addService=add;
    }

    @Override
    public ServiceCall<String, Operandes, Integer> compute() {
        System.out.println("helle");
        return (id, operandes) -> addService.op().invoke(NotUsed.getInstance(),NotUsed.getInstance());
    }
}
