/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package com.zenika.user.impl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.lightbend.lagom.serialization.CompressedJsonable;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/**
 * The state for the {@link User} entity.
 */
@SuppressWarnings("serial")
@Immutable
@JsonDeserialize
public final class UsersState implements CompressedJsonable {

  public final UsersList users;
  public final String timestamp;

  @JsonCreator
  public UsersState(UsersList users, String timestamp) {
    this.users = Preconditions.checkNotNull(users, "users");
    this.timestamp = Preconditions.checkNotNull(timestamp, "timestamp");
  }

  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another)
      return true;
    return another instanceof UsersState && equalTo((UsersState) another);
  }

  private boolean equalTo(UsersState another) {
    return users.equals(another.users) && timestamp.equals(another.timestamp);
  }

  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + users.hashCode();
    h = h * 17 + timestamp.hashCode();
    return h;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper("UsersState").add("user List", users).add("timestamp", timestamp).toString();
  }
}
