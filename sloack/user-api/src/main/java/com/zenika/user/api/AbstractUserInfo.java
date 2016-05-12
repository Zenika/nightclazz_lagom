package com.zenika.user.api;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lightbend.lagom.javadsl.immutable.ImmutableStyle;
import org.immutables.value.Value;

import javax.annotation.concurrent.Immutable;

@Value.Immutable
@ImmutableStyle
@Immutable
@JsonDeserialize
public interface AbstractUserInfo {
    @Value.Parameter
    String getName();

}
