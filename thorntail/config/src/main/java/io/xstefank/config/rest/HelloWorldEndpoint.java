package io.xstefank.config.rest;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.List;

@ApplicationScoped
@Path("/hello")
public class HelloWorldEndpoint {

	@Inject
	@ConfigProperty(name="myprj.some.dynamic.timeout", defaultValue="100")
	private javax.inject.Provider<Long> timeout;

	@Inject @ConfigProperty(name="myPets") private List<String> myListPets;

	@GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok("Hello from Thorntail! " + myListPets).build();
	}
}
