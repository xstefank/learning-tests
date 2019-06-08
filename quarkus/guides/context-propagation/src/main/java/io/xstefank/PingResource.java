package io.xstefank;

import org.eclipse.microprofile.context.ThreadContext;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @Inject
    private ThreadContext threadContext;
    
    @GET
    @Path("cs")
    public CompletionStage<String> getHello() {
        ThreadLocal<String> s = new ThreadLocal<>();

        return threadContext.withContextCapture(CompletableFuture.supplyAsync(() -> {
            s.set("hello from first thread");
            return "hi";
        })).thenApply(x -> {
            System.out.println(s.get());
            return x;
        });
    }
}
