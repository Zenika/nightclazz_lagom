/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package com.zenika.user.impl;

import akka.Done;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.lightbend.lagom.javadsl.persistence.PersistentEntity;
import com.lightbend.lagom.serialization.CompressedJsonable;
import com.lightbend.lagom.serialization.Jsonable;
import com.zenika.user.api.UserInfo;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import java.util.List;

/**
 * This interface defines all the commands that the HelloWorld entity supports.
 * <p>
 * By convention, the commands should be inner classes of the interface, which
 * makes it simple to get a complete picture of what commands an entity
 * supports.
 */
public interface UserCommand extends Jsonable {

    /**
     * A command to switch the greeting name.
     * <p>
     * It has a reply type of {@link akka.Done}, which is sent back to the caller
     * when all the events emitted by this command are successfully persisted.
     */
    @SuppressWarnings("serial")
    @Immutable
    @JsonDeserialize
    public final class SignIn implements UserCommand, CompressedJsonable, PersistentEntity.ReplyType<Done> {
        public final String name;

        @JsonCreator
        public SignIn(String name) {
            this.name = Preconditions.checkNotNull(name, "name");
        }

        @Override
        public boolean equals(@Nullable Object another) {
            if (this == another)
                return true;
            return another instanceof SignIn && equalTo((SignIn) another);
        }

        private boolean equalTo(SignIn another) {
            return name.equals(another.name);
        }

        @Override
        public int hashCode() {
            int h = 31;
            h = h * 17 + name.hashCode();
            return h;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper("SignIn").add("name", name).toString();
        }
    }

    /**
     * A command to say hello to someone using the current greeting name.
     * <p>
     * The reply type is String, and will contain the name to say to that
     * person.
     */
    @SuppressWarnings("serial")
    @Immutable
    @JsonDeserialize
    public final class Users implements UserCommand, PersistentEntity.ReplyType<List<UserInfo>> {
    }

}
