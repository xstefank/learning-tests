package org.xstefank;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("")
@ApplicationScoped
public class TestResource {
    
    @GET
    public void get() {
        BeanManager beanManager = CDI.current().getBeanManager();
        Logger log = Logger.getLogger("XXXXXXXXXXXx");
        RegisterLRAParticipantExtension.names
                .forEach(c -> {
                    log.error("Trying " + c.getName());
                    beanManager.getBeans(c).forEach(b -> log.error(b.getScope()));
                });
    }

    @Inject
    private TestRegistry testRegistry;
    
    @GET
    @Path("registry")
    public String getRegistryValue() {
        return testRegistry.getValue();
    }
}
