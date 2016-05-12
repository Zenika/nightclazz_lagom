/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package com.zenika.msg.api.impl;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import com.zenika.msg.api.MessageStream;

/**
 * The module that binds the HelloStream so that it can be served.
 */
public class MessageStreamModule extends AbstractModule implements ServiceGuiceSupport {
  @Override
  protected void configure() {
    // Bind the HelloStream service
    bindServices(serviceBinding(MessageStream.class, MessageStreamImpl.class));

  }
}
