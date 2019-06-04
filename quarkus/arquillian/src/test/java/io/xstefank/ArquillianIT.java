package io.xstefank;

import io.xstefank.resource.TestResource;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

@RunWith(Arquillian.class)
public class ArquillianIT {
    
    @ArquillianResource
    String url;
    
    @Deployment
    public static JavaArchive deploy() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
            .addClasses(TestResource.class);
    }
    
    @Test
    public void test() {
        Response response = ClientBuilder.newClient()
            .target(url + "/test")
            .request().get();

        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }
}
