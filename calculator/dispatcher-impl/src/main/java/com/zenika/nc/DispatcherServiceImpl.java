package com.zenika.nc;

import com.google.inject.Inject;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.ServiceLocator;
import play.api.libs.ws.WSClient;
import play.api.libs.ws.WSResponse;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Created by fsznajderman on 04/04/2016.
 */
public class DispatcherServiceImpl implements DispatcherService {

    final ServiceLocator sl;
    final WSClient wsClient;

    @Inject
    public DispatcherServiceImpl(ServiceLocator sl, WSClient wsClient) {
        this.sl = sl;
        this.wsClient = wsClient;
    }

    @Override
    public ServiceCall<String, Operandes, Integer> compute() {
        return (id, operandes) -> {
            System.out.println("name " + operandes);

            CompletionStage<WSResponse> cs = sl.doWithService("add", uri -> {
                System.out.println(uri);

                return wsClient.url(uri + "/api/hello").get();
            });

            return cs;
        };
    }
}
