package com.zenika.msg.api;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lightbend.lagom.javadsl.immutable.ImmutableStyle;
import org.immutables.value.Value;
/**
 * Created by fs24818n on 10/05/2016.
 */
@Value.Immutable
@ImmutableStyle
@JsonSerialize(as = SloackMessage.class)
@JsonDeserialize(as = SloackMessage.class)
public interface AbstractSloackMessage {

    @Value.Parameter
    String getName();
    @Value.Parameter
    String getMessage();
}
