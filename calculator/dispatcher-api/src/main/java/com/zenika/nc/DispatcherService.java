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
public interface DispatcherService extends Service {

    ServiceCall<NotUsed, NotUsed, NotUsed> compute();

    @Override
    default Descriptor descriptor() {
        /**
         * TODO :
         * Service name : dispatcher
         * it should expose the following service /api/calculator/:op,
         * id : label of operation : add, min, mult, div
         * request : an object of type Operandes
         * response : Integer
         *
         * /!\ don't forget Acl
         */
    }
}

