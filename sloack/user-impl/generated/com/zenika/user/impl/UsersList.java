package com.zenika.user.impl;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.zenika.user.api.UserInfo;

import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link AbstractUsersList}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code UsersList.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code UsersList.of()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "AbstractUsersList"})
@Immutable
public final class UsersList implements AbstractUsersList {
  private final ImmutableList<UserInfo> users;

  private UsersList(Iterable<? extends UserInfo> users) {
    this.users = ImmutableList.copyOf(users);
  }

  private UsersList(UsersList original, ImmutableList<UserInfo> users) {
    this.users = users;
  }

  /**
   * @return The value of the {@code users} attribute
   */
  @Override
  public ImmutableList<UserInfo> getUsers() {
    return users;
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link AbstractUsersList#getUsers() users}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final UsersList withUsers(UserInfo... elements) {
    ImmutableList<UserInfo> newValue = ImmutableList.copyOf(elements);
    return new UsersList(this, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link AbstractUsersList#getUsers() users}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of users elements to set
   * @return A modified copy of {@code this} object
   */
  public final UsersList withUsers(Iterable<? extends UserInfo> elements) {
    if (this.users == elements) return this;
    ImmutableList<UserInfo> newValue = ImmutableList.copyOf(elements);
    return new UsersList(this, newValue);
  }

  /**
   * This instance is equal to all instances of {@code UsersList} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof UsersList
        && equalTo((UsersList) another);
  }

  private boolean equalTo(UsersList another) {
    return users.equals(another.users);
  }

  /**
   * Computes a hash code from attributes: {@code users}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + users.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code UsersList...} with all non-generated
   * and non-auxiliary attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("UsersList")
        .add("users", users)
        .toString();
  }

  /**
   * Construct a new immutable {@code UsersList} instance.
   * @param users The value for the {@code users} attribute
   * @return An immutable UsersList instance
   */
  public static UsersList of(List<UserInfo> users) {
    return of((Iterable<? extends UserInfo>) users);
  }

  /**
   * Construct a new immutable {@code UsersList} instance.
   * @param users The value for the {@code users} attribute
   * @return An immutable UsersList instance
   */
  public static UsersList of(Iterable<? extends UserInfo> users) {
    return new UsersList(users);
  }

  /**
   * Creates an immutable copy of a {@link AbstractUsersList} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable UsersList instance
   */
  public static UsersList copyOf(AbstractUsersList instance) {
    if (instance instanceof UsersList) {
      return (UsersList) instance;
    }
    return UsersList.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link com.zenika.user.impl.UsersList UsersList}.
   * @return A new UsersList builder
   */
  public static UsersList.Builder builder() {
    return new UsersList.Builder();
  }

  /**
   * Builds instances of type {@link com.zenika.user.impl.UsersList UsersList}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private ImmutableList.Builder<UserInfo> usersBuilder = ImmutableList.builder();

    private Builder() {}

    /**
     * Fill a builder with attribute values from the provided {@link AbstractUsersList} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(AbstractUsersList instance) {
      Preconditions.checkNotNull(instance, "instance");
      addAllUsers(instance.getUsers());
      return this;
    }

    /**
     * Adds one element to {@link AbstractUsersList#getUsers() users} list.
     * @param element A users element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addUsers(UserInfo element) {
      usersBuilder.add(element);
      return this;
    }

    /**
     * Adds elements to {@link AbstractUsersList#getUsers() users} list.
     * @param elements An array of users elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addUsers(UserInfo... elements) {
      usersBuilder.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link AbstractUsersList#getUsers() users} list.
     * @param elements An iterable of users elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder users(Iterable<? extends UserInfo> elements) {
      usersBuilder = ImmutableList.builder();
      return addAllUsers(elements);
    }

    /**
     * Adds elements to {@link AbstractUsersList#getUsers() users} list.
     * @param elements An iterable of users elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllUsers(Iterable<? extends UserInfo> elements) {
      usersBuilder.addAll(elements);
      return this;
    }
    /**
     * Builds a new {@link com.zenika.user.impl.UsersList UsersList}.
     * @return An immutable instance of UsersList
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public UsersList build()
        throws IllegalStateException {
      return new UsersList(null, usersBuilder.build());
    }
  }
}
