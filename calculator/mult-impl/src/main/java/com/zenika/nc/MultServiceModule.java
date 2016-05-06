package com.zenika.nc;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

/**
 * Created by fsznajderman on 04/04/2016.
 */
public class MultServiceModule
        extends AbstractModule implements ServiceGuiceSupport

{
    @Override
    protected void configure() {
        bindServices(serviceBinding(MultService.class, MultServiceImpl.class));
    }
}
