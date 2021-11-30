package io.xstefank;

import io.quarkus.oidc.OidcConfigurationMetadata;
import io.quarkus.oidc.UserInfo;
import io.quarkus.security.Authenticated;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/service")
@Authenticated
public class ProtectedResource {

    @Inject
    JsonWebToken accessToken;
    @Inject
    UserInfo userInfo;
    @Inject
    OidcConfigurationMetadata configMetadata;

    @GET
    @Path("test-security-oidc")
    public String testSecurityOidc() {
        return accessToken.getName() + ":" + accessToken.getGroups().iterator().next();
    }

    @GET
    @Path("test-security-oidc-claims-userinfo-metadata")
    public String testSecurityOidcWithClaimsUserInfoMetadata() {
        return accessToken.getName() + ":" + accessToken.getGroups().iterator().next()
            + ":" + accessToken.getClaim("email")
            + ":" + userInfo.getString("sub")
            + ":" + configMetadata.get("issuer");
    }
}
