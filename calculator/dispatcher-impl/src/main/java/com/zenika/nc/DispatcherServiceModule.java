package com.zenika.nc;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

/**
 * Created by fsznajderman on 04/04/2016.
 */
public class DispatcherServiceModule
        extends AbstractModule implements ServiceGuiceSupport

{
    @Override
    protected void configure() {
        bindServices(serviceBinding(DispatcherService.class, DispatcherServiceImpl.class));
        /**
         * TODO :
         * To enable injection, you have to bind each service as client.
         * (bindClient(..) method might help you)
         */
    }
}
