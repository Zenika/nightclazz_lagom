/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package com.zenika.msg.api.impl;

import akka.NotUsed;
import akka.stream.javadsl.Source;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.pubsub.PubSubRef;
import com.lightbend.lagom.javadsl.pubsub.PubSubRegistry;
import com.lightbend.lagom.javadsl.pubsub.TopicId;
import com.zenika.msg.api.AbstractSloackMessage;
import com.zenika.msg.api.MessageStream;
import com.zenika.msg.api.SloackMessage;

import java.util.concurrent.CompletableFuture;

/**
 * Implementation of the HelloString.
 */
public class MessageStreamImpl implements MessageStream {

    private static final String TOPIC_ID = "sloackChat";


    private PubSubRegistry pusub;

    public MessageStreamImpl(PubSubRegistry pusub) {
        this.pusub = pusub;
    }

    @Override
    public ServiceCall<NotUsed, SloackMessage, NotUsed> message() {
        return (id, message) -> {
            final PubSubRef<SloackMessage> ref = pusub.refFor(TopicId.of(SloackMessage.class, TOPIC_ID));

            ref.publish(message);
            return CompletableFuture.completedFuture(NotUsed.getInstance());
        };
    }

    @Override
    public ServiceCall<NotUsed, NotUsed, Source<SloackMessage, NotUsed>> stream() {
        return (id, message) -> {
            final PubSubRef<SloackMessage> ref = pusub.refFor(TopicId.of(SloackMessage.class, TOPIC_ID));
            return CompletableFuture.completedFuture(ref.subscriber());

        };
    }
}
