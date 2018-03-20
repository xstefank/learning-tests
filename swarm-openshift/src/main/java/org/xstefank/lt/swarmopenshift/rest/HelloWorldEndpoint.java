package org.xstefank.lt.swarmopenshift.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@ApplicationScoped
@Path("/hello")
public class HelloWorldEndpoint {

	@GET
	@Produces("text/plain")
	public Response doGet() {
		String test_prop = System.getProperty("TEST_PROP");

		return Response.ok("Hello from " + test_prop).build();
	}
}
