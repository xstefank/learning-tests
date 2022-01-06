package io.xstefank;

import org.jboss.weld.context.WeldAlterableContext;
import org.jboss.weld.context.api.ContextualInstance;
import org.jboss.weld.context.bound.BoundConversationContext;
import org.jboss.weld.context.bound.BoundLiteral;
import org.jboss.weld.context.bound.BoundRequest;
import org.jboss.weld.context.bound.BoundRequestContext;
import org.jboss.weld.context.bound.BoundSessionContext;
import org.jboss.weld.context.bound.MutableBoundRequest;
import org.jboss.weld.manager.api.WeldManager;

import javax.enterprise.inject.spi.CDI;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Path("ping")
public class PingResource {

    private static final ExecutorService executor = Executors.newFixedThreadPool(1);
    
    @GET
    public Response ping() {
        // gather all the contexts we want to propagate and the instances in them
        Map<Class<? extends Annotation>, Collection<ContextualInstance<?>>> scopeToContextualInstances = new HashMap<>();
        for (WeldAlterableContext context : CDI.current().select(WeldManager.class).get().getActiveWeldAlterableContexts()) {
            scopeToContextualInstances.put(context.getScope(), context.getAllContextualInstances());
        }
        // We create a task wrapper which will make sure we have contexts propagated
        Callable<Response> wrappedTask = new Callable<Response>() {

            @Override
            public Response call() throws Exception {
                // Get WeldManager,get instances of @Bound contexts for request, session and conversation scopes
                WeldManager weldManager = CDI.current().select(WeldManager.class).get();
                BoundRequestContext requestContext = weldManager.instance().select(BoundRequestContext.class, BoundLiteral.INSTANCE).get();
                BoundSessionContext sessionContext = weldManager.instance().select(BoundSessionContext.class, BoundLiteral.INSTANCE).get();
                BoundConversationContext conversationContext = weldManager.instance().select(BoundConversationContext.class, BoundLiteral.INSTANCE).get();

                // We will be using bound contexts, prepare backing structures for contexts
                Map<String, Object> sessionMap = new HashMap<>();
                Map<String, Object> requestMap = new HashMap<>();
                BoundRequest boundRequest = new MutableBoundRequest(requestMap, sessionMap);

                // activate contexts
                requestContext.associate(requestMap);
                requestContext.activate();
                sessionContext.associate(sessionMap);
                sessionContext.activate();
                conversationContext.associate(boundRequest);
                conversationContext.activate();

                // propagate all contexts that have some bean in them
                if (scopeToContextualInstances.get(requestContext.getScope()) != null) {
                    requestContext.clearAndSet(scopeToContextualInstances.get(requestContext.getScope()));
                }
                if (scopeToContextualInstances.get(sessionContext.getScope()) != null) {
                    sessionContext.clearAndSet(scopeToContextualInstances.get(sessionContext.getScope()));
                }
                if (scopeToContextualInstances.get(conversationContext.getScope()) != null) {
                    conversationContext.clearAndSet(scopeToContextualInstances.get(conversationContext.getScope()));
                }

                // now execute the actual original task
                    Response response = ClientBuilder.newClient()
                        .target("http://example.com")
                        .request()
                        .get();
                    System.out.println(Thread.currentThread().getId() + " " + response.getStatus());
                    Response result =  Response.ok("Application deployed successfully").build();

                // cleanup, context deactivation, do not trigger @PreDestroy/@Disposes
                requestContext.deactivate();
                conversationContext.deactivate();
                sessionContext.deactivate();

                // all done, return
                return result;
            }
        };

        executor.submit(wrappedTask);

        return Response.ok().build();
    }
}
