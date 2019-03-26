package io.xstefank;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

@Path("/ping")
public class PingResource {

    private Logger utilLogger = Logger.getLogger("UtilLogger");
    private org.jboss.logging.Logger jbossLogger = org.jboss.logging.Logger.getLogger("JBossLogger");

    @Inject
    private Config config;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        utilLogger.info("Info");
        jbossLogger.info("info");
        
        utilLogger.fine("fine");
        jbossLogger.debug("debug");
        
        return config.getPropertyNames().toString();
    }
}
