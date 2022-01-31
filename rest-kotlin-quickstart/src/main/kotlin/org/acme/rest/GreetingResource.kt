package org.acme.rest

import io.quarkus.runtime.annotations.RegisterForReflection
import org.eclipse.microprofile.faulttolerance.CircuitBreaker
import org.eclipse.microprofile.faulttolerance.ExecutionContext
import org.eclipse.microprofile.faulttolerance.Fallback
import org.eclipse.microprofile.faulttolerance.FallbackHandler
import org.jboss.logging.Logger
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("/greeting")
class GreetingResource {

    @GET
    @Path("/testFallbackUrl")
    @Fallback(DistanceServiceFallback::class)
    @CircuitBreaker(
            requestVolumeThreshold = 4, failureRatio = 0.75, delay = 5000, successThreshold = 3
    )
    fun getDistanceData(@QueryParam("date") date: String) : MutableList<String> {
        return mutableListOf("Default")
    }

    @RegisterForReflection
    class DistanceServiceFallback : FallbackHandler<MutableList<String>> {

        @field:Default
        @field:Inject
        lateinit var logger: Logger

        override fun handle(context: ExecutionContext?): MutableList<String> {
            logger.error("Inside DistanceServiceFallback handler. ")
            return mutableListOf("Hello")
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello RESTEasy Reactive"
}