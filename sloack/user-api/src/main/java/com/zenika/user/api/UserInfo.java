package com.zenika.user.api;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

@Immutable
@JsonDeserialize
public final class UserInfo {

  public final String name;

  @JsonCreator
  public UserInfo(String message) {
    this.name = Preconditions.checkNotNull(message, "name");
  }

  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another)
      return true;
    return another instanceof UserInfo && equalTo((UserInfo) another);
  }

  private boolean equalTo(UserInfo another) {
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
    return MoreObjects.toStringHelper("User info").add("name", name).toString();
  }
}
