package com.zenika.helloworld.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

/**
 * The hello service interface.
 * <p>
 * This describes everything that Lagom needs to know about how to serve and
 * consume the HelloService.
 */
public interface HelloService extends Service {

    /**
     * Example: curl http://localhost:9000/api/hello/Alice
     */

    /*
    * Todo :
    * Give the right type for id and response
    * */
    ServiceCall<NotUsed, NotUsed, NotUsed> hello();


    @Override
    default Descriptor descriptor() {
        return
        /*
         *   Todo :
         *   Give name to the service
         *   Describe route for hello Service with the right HTTP Verb
         *   /!\ don't forget ACL.
        */
    }
}
