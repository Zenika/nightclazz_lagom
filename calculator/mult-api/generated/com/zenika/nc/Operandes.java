package com.zenika.nc;

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
 * Immutable implementation of {@link AbstractOperandes}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code Operandes.builder()}.
 * Use the static factory method to create immutable instances:
 * {@code Operandes.of()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Generated({"Immutables.generator", "AbstractOperandes"})
@Immutable
public final class Operandes implements AbstractOperandes {
  private final Integer op1;
  private final Integer op2;

  private Operandes(Integer op1, Integer op2) {
    this.op1 = Preconditions.checkNotNull(op1, "op1");
    this.op2 = Preconditions.checkNotNull(op2, "op2");
  }

  private Operandes(Operandes original, Integer op1, Integer op2) {
    this.op1 = op1;
    this.op2 = op2;
  }

  /**
   * @return The value of the {@code op1} attribute
   */
  @JsonProperty
  @Override
  public Integer getOp1() {
    return op1;
  }

  /**
   * @return The value of the {@code op2} attribute
   */
  @JsonProperty
  @Override
  public Integer getOp2() {
    return op2;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractOperandes#getOp1() op1} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for op1
   * @return A modified copy of the {@code this} object
   */
  public final Operandes withOp1(Integer value) {
    if (this.op1 == value) return this;
    Integer newValue = Preconditions.checkNotNull(value, "op1");
    return new Operandes(this, newValue, this.op2);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractOperandes#getOp2() op2} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for op2
   * @return A modified copy of the {@code this} object
   */
  public final Operandes withOp2(Integer value) {
    if (this.op2 == value) return this;
    Integer newValue = Preconditions.checkNotNull(value, "op2");
    return new Operandes(this, this.op1, newValue);
  }

  /**
   * This instance is equal to all instances of {@code Operandes} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof Operandes
        && equalTo((Operandes) another);
  }

  private boolean equalTo(Operandes another) {
    return op1.equals(another.op1)
        && op2.equals(another.op2);
  }

  /**
   * Computes a hash code from attributes: {@code op1}, {@code op2}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + op1.hashCode();
    h = h * 17 + op2.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Operandes...} with all non-generated
   * and non-auxiliary attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Operandes")
        .add("op1", op1)
        .add("op2", op2)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  static final class Json implements AbstractOperandes {
    @Nullable Integer op1;
    @Nullable Integer op2;

    public void setOp1(Integer op1) {
      this.op1 = op1;
    }

    public void setOp2(Integer op2) {
      this.op2 = op2;
    }
    @Override
    public Integer getOp1() { throw new UnsupportedOperationException(); }
    @Override
    public Integer getOp2() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static Operandes fromJson(Json json) {
    Operandes.Builder builder = Operandes.builder();
    if (json.op1 != null) {
      builder.op1(json.op1);
    }
    if (json.op2 != null) {
      builder.op2(json.op2);
    }
    return builder.build();
  }

  /**
   * Construct a new immutable {@code Operandes} instance.
   * @param op1 The value for the {@code op1} attribute
   * @param op2 The value for the {@code op2} attribute
   * @return An immutable Operandes instance
   */
  public static Operandes of(Integer op1, Integer op2) {
    return new Operandes(op1, op2);
  }

  /**
   * Creates an immutable copy of a {@link AbstractOperandes} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Operandes instance
   */
  public static Operandes copyOf(AbstractOperandes instance) {
    if (instance instanceof Operandes) {
      return (Operandes) instance;
    }
    return Operandes.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link com.zenika.nc.Operandes Operandes}.
   * @return A new Operandes builder
   */
  public static Operandes.Builder builder() {
    return new Operandes.Builder();
  }

  /**
   * Builds instances of type {@link com.zenika.nc.Operandes Operandes}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_OP1 = 0x1L;
    private static final long INIT_BIT_OP2 = 0x2L;
    private long initBits = 0x3;

    private @Nullable Integer op1;
    private @Nullable Integer op2;

    private Builder() {}

    /**
     * Fill a builder with attribute values from the provided {@link AbstractOperandes} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(AbstractOperandes instance) {
      Preconditions.checkNotNull(instance, "instance");
      op1(instance.getOp1());
      op2(instance.getOp2());
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractOperandes#getOp1() op1} attribute.
     * @param op1 The value for op1 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder op1(Integer op1) {
      this.op1 = Preconditions.checkNotNull(op1, "op1");
      initBits &= ~INIT_BIT_OP1;
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractOperandes#getOp2() op2} attribute.
     * @param op2 The value for op2 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder op2(Integer op2) {
      this.op2 = Preconditions.checkNotNull(op2, "op2");
      initBits &= ~INIT_BIT_OP2;
      return this;
    }
    /**
     * Builds a new {@link com.zenika.nc.Operandes Operandes}.
     * @return An immutable instance of Operandes
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public Operandes build()
        throws IllegalStateException {
      checkRequiredAttributes(); return new Operandes(null, op1, op2);
    }

    private boolean op1IsSet() {
      return (initBits & INIT_BIT_OP1) == 0;
    }

    private boolean op2IsSet() {
      return (initBits & INIT_BIT_OP2) == 0;
    }

    private void checkRequiredAttributes() throws IllegalStateException {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
    }
    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if (!op1IsSet()) attributes.add("op1");
      if (!op2IsSet()) attributes.add("op2");
      return "Cannot build Operandes, some of required attributes are not set " + attributes;
    }
  }
}
