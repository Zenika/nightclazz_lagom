package com.zenika.nc;

import akka.NotUsed;
import com.google.inject.Inject;
import com.lightbend.lagom.javadsl.api.ServiceCall;


/**
 * Created by fsznajderman on 04/04/2016.
 */
public class DispatcherServiceImpl implements DispatcherService {

    final AddService addService;
    final MinService minService;
    final MultService multService;
    final DivService divService;

    @Inject
    public DispatcherServiceImpl(/** TODO:  must inject services that used to compute operations **/) {

    }

    @Override
    public ServiceCall<String, Operandes, Integer> compute() {


        return (id, operandes) -> getService(id).invoke(NotUsed.getInstance(), operandes);
    }


    private ServiceCall<NotUsed, Operandes, Integer> getService(String op) {
        final ServiceCall<NotUsed, Operandes, Integer> r;
        switch (op) {
            case "mult":
                r = multService.op();
                break;
            case "div":
                r = divService.op();
                break;
            case "add":
                r = addService.op();
                break;
            case "min":
                r = minService.op();
                break;
            default:
                throw new IllegalArgumentException(op);
        }
        return r;
    }
}
