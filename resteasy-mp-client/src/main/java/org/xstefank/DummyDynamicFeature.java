package org.xstefank;

import org.jboss.logging.Logger;

import javax.servlet.ServletContext;
import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class DummyDynamicFeature implements DynamicFeature {

    @Context
    ServletContext servletContext; 
    
    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        Logger.getLogger("XXXXXXXXXXXXXXXXXXXX").error(servletContext.getAttributeNames());
    }
}
