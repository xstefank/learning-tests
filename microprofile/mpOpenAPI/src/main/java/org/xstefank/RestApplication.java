package org.xstefank;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("")
@OpenAPIDefinition(
        info = @Info(
                title = "Ping app",
                description = "Testing ping application",
                version = "1.0",
                contact = @Contact(
                        name = "Martin Stefanko",
                        email = "mstefank@redhat.com"
                )
        )
)
public class RestApplication extends Application {
    
}
