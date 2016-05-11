/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package com.zenika.user.impl;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.lightbend.lagom.serialization.Jsonable;


public interface UserEvent extends Jsonable {


  @SuppressWarnings("serial")
  @Immutable
  @JsonDeserialize
  public final class UserSigned implements UserEvent {
    public final String name;

    @JsonCreator
    public UserSigned(String name) {
      this.name= Preconditions.checkNotNull(name, "name");
    }

    @Override
    public boolean equals(@Nullable Object another) {
      if (this == another)
        return true;
      return another instanceof UserSigned && equalTo((UserSigned) another);
    }

    private boolean equalTo(UserSigned another) {
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
      return MoreObjects.toStringHelper("UserSigned").add("name", name).toString();
    }
  }
}
