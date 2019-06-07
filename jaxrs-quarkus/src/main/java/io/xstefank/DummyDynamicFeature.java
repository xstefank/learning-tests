package io.xstefank;

import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
//@ConstrainedTo(RuntimeType.CLIENT)
public class DummyDynamicFeature implements DynamicFeature {
    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
//        if (resourceInfo.getResourceMethod().isAnnotationPresent(AbortWith456.class)) {
            context.register(DummyWriterInterceptor.class);
//        }
    }
}
