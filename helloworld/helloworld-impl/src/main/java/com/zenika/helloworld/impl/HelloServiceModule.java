/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package com.zenika.helloworld.impl;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import com.zenika.helloworld.api.HelloService;

/**
 * The module that binds the HelloService so that it can be served.
 */
public class HelloServiceModule extends AbstractModule implements ServiceGuiceSupport {
  @Override
  protected void configure() {
    /*
     *Todo :
     * Do the binding between API and implementation
     */
  }
}
