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
    public DispatcherServiceImpl(AddService add, MultService mult, MinService min, DivService div) {
        this.addService = add;
        this.divService = div;
        this.multService = mult;
        this.minService = min;
    }

    @Override
    public ServiceCall<Operandes, Integer> compute(String id) {


        return (operandes) -> getService(id).invoke(operandes);
    }


    private ServiceCall<Operandes, Integer> getService(String op) {
        final ServiceCall<Operandes, Integer> r;
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
