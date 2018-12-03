package org.xstefank.jaxrsoctetstreamtt.rest;


import javax.ws.rs.Path;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;


@Path("/hello")
public class HelloWorldEndpoint {

	@GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok("Hello from Thorntail!").build();
	}

	@GET
	@Path("octetStream")
	public Response octetStream() {
		return Response.status(Response.Status.OK).entity(Entity.text("Hello from octet-stream")).build();
	}
}
