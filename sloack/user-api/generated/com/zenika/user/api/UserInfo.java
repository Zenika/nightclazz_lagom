package com.zenika.user.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link AbstractUserInfo}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code UserInfo.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code UserInfo.of()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "AbstractUserInfo"})
@Immutable
public final class UserInfo implements AbstractUserInfo {
  private final String name;

  private UserInfo(String name) {
    this.name = Preconditions.checkNotNull(name, "name");
  }

  private UserInfo(UserInfo original, String name) {
    this.name = name;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @JsonProperty
  @Override
  public String getName() {
    return name;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractUserInfo#getName() name} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final UserInfo withName(String value) {
    if (this.name == value) return this;
    String newValue = Preconditions.checkNotNull(value, "name");
    return new UserInfo(this, newValue);
  }

  /**
   * This instance is equal to all instances of {@code UserInfo} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof UserInfo
        && equalTo((UserInfo) another);
  }

  private boolean equalTo(UserInfo another) {
    return name.equals(another.name);
  }

  /**
   * Computes a hash code from attributes: {@code name}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + name.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code UserInfo...} with all non-generated
   * and non-auxiliary attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("UserInfo")
        .add("name", name)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  static final class Json implements AbstractUserInfo {
    @Nullable String name;

    public void setName(String name) {
      this.name = name;
    }
    @Override
    public String getName() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static UserInfo fromJson(Json json) {
    UserInfo.Builder builder = UserInfo.builder();
    if (json.name != null) {
      builder.name(json.name);
    }
    return builder.build();
  }

  /**
   * Construct a new immutable {@code UserInfo} instance.
   * @param name The value for the {@code name} attribute
   * @return An immutable UserInfo instance
   */
  public static UserInfo of(String name) {
    return new UserInfo(name);
  }

  /**
   * Creates an immutable copy of a {@link AbstractUserInfo} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable UserInfo instance
   */
  public static UserInfo copyOf(AbstractUserInfo instance) {
    if (instance instanceof UserInfo) {
      return (UserInfo) instance;
    }
    return UserInfo.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link com.zenika.user.api.UserInfo UserInfo}.
   * @return A new UserInfo builder
   */
  public static UserInfo.Builder builder() {
    return new UserInfo.Builder();
  }

  /**
   * Builds instances of type {@link com.zenika.user.api.UserInfo UserInfo}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private long initBits = 0x1;

    private @Nullable String name;

    private Builder() {}

    /**
     * Fill a builder with attribute values from the provided {@link AbstractUserInfo} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(AbstractUserInfo instance) {
      Preconditions.checkNotNull(instance, "instance");
      name(instance.getName());
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractUserInfo#getName() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder name(String name) {
      this.name = Preconditions.checkNotNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }
    /**
     * Builds a new {@link com.zenika.user.api.UserInfo UserInfo}.
     * @return An immutable instance of UserInfo
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public UserInfo build()
        throws IllegalStateException {
      checkRequiredAttributes(); return new UserInfo(null, name);
    }

    private boolean nameIsSet() {
      return (initBits & INIT_BIT_NAME) == 0;
    }

    private void checkRequiredAttributes() throws IllegalStateException {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }
    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if (!nameIsSet()) attributes.add("name");
      return "Cannot build UserInfo, some of required attributes are not set " + attributes;
    }
  }
}
