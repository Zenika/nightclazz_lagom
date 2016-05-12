package com.zenika.nc;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lightbend.lagom.javadsl.immutable.ImmutableStyle;
import org.immutables.value.Value;

/**
 * Created by fsznajderman on 03/04/2016.
 */
@Value.Immutable
@ImmutableStyle
@JsonSerialize(as = Operandes.class)
@JsonDeserialize(as = Operandes.class)
public interface AbstractOperandes {

    @Value.Parameter
    Integer getOp1();

    @Value.Parameter
    Integer getOp2();


}
