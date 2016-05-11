package com.zenika.msg.api;

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
 * Immutable implementation of {@link AbstractSloackMessage}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code SloackMessage.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code SloackMessage.of()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "AbstractSloackMessage"})
@Immutable
public final class SloackMessage implements AbstractSloackMessage {
  private final String name;
  private final String message;

  private SloackMessage(String name, String message) {
    this.name = Preconditions.checkNotNull(name, "name");
    this.message = Preconditions.checkNotNull(message, "message");
  }

  private SloackMessage(SloackMessage original, String name, String message) {
    this.name = name;
    this.message = message;
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
   * @return The value of the {@code message} attribute
   */
  @JsonProperty
  @Override
  public String getMessage() {
    return message;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractSloackMessage#getName() name} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final SloackMessage withName(String value) {
    if (this.name == value) return this;
    String newValue = Preconditions.checkNotNull(value, "name");
    return new SloackMessage(this, newValue, this.message);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractSloackMessage#getMessage() message} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for message
   * @return A modified copy of the {@code this} object
   */
  public final SloackMessage withMessage(String value) {
    if (this.message == value) return this;
    String newValue = Preconditions.checkNotNull(value, "message");
    return new SloackMessage(this, this.name, newValue);
  }

  /**
   * This instance is equal to all instances of {@code SloackMessage} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof SloackMessage
        && equalTo((SloackMessage) another);
  }

  private boolean equalTo(SloackMessage another) {
    return name.equals(another.name)
        && message.equals(another.message);
  }

  /**
   * Computes a hash code from attributes: {@code name}, {@code message}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + name.hashCode();
    h = h * 17 + message.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code SloackMessage...} with all non-generated
   * and non-auxiliary attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("SloackMessage")
        .add("name", name)
        .add("message", message)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  static final class Json implements AbstractSloackMessage {
    @Nullable String name;
    @Nullable String message;

    public void setName(String name) {
      this.name = name;
    }

    public void setMessage(String message) {
      this.message = message;
    }
    @Override
    public String getName() { throw new UnsupportedOperationException(); }
    @Override
    public String getMessage() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static SloackMessage fromJson(Json json) {
    SloackMessage.Builder builder = SloackMessage.builder();
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.message != null) {
      builder.message(json.message);
    }
    return builder.build();
  }

  /**
   * Construct a new immutable {@code SloackMessage} instance.
   * @param name The value for the {@code name} attribute
   * @param message The value for the {@code message} attribute
   * @return An immutable SloackMessage instance
   */
  public static SloackMessage of(String name, String message) {
    return new SloackMessage(name, message);
  }

  /**
   * Creates an immutable copy of a {@link AbstractSloackMessage} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable SloackMessage instance
   */
  public static SloackMessage copyOf(AbstractSloackMessage instance) {
    if (instance instanceof SloackMessage) {
      return (SloackMessage) instance;
    }
    return SloackMessage.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link com.zenika.msg.api.SloackMessage SloackMessage}.
   * @return A new SloackMessage builder
   */
  public static SloackMessage.Builder builder() {
    return new SloackMessage.Builder();
  }

  /**
   * Builds instances of type {@link com.zenika.msg.api.SloackMessage SloackMessage}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_MESSAGE = 0x2L;
    private long initBits = 0x3;

    private @Nullable String name;
    private @Nullable String message;

    private Builder() {}

    /**
     * Fill a builder with attribute values from the provided {@link AbstractSloackMessage} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(AbstractSloackMessage instance) {
      Preconditions.checkNotNull(instance, "instance");
      name(instance.getName());
      message(instance.getMessage());
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractSloackMessage#getName() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder name(String name) {
      this.name = Preconditions.checkNotNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractSloackMessage#getMessage() message} attribute.
     * @param message The value for message 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder message(String message) {
      this.message = Preconditions.checkNotNull(message, "message");
      initBits &= ~INIT_BIT_MESSAGE;
      return this;
    }
    /**
     * Builds a new {@link com.zenika.msg.api.SloackMessage SloackMessage}.
     * @return An immutable instance of SloackMessage
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public SloackMessage build()
        throws IllegalStateException {
      checkRequiredAttributes(); return new SloackMessage(null, name, message);
    }

    private boolean nameIsSet() {
      return (initBits & INIT_BIT_NAME) == 0;
    }

    private boolean messageIsSet() {
      return (initBits & INIT_BIT_MESSAGE) == 0;
    }

    private void checkRequiredAttributes() throws IllegalStateException {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }
    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if (!nameIsSet()) attributes.add("name");
      if (!messageIsSet()) attributes.add("message");
      return "Cannot build SloackMessage, some of required attributes are not set " + attributes;
    }
  }
}
