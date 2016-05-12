package com.zenika.user.impl;

import com.lightbend.lagom.javadsl.immutable.ImmutableStyle;
import com.zenika.user.api.UserInfo;
import org.immutables.value.Value;

import java.util.List;

/**
 * Created by fs24818n on 11/05/2016.
 */
@Value.Immutable
@ImmutableStyle
public interface AbstractUsersList {

    @Value.Parameter
    List<UserInfo> getUsers();
}
