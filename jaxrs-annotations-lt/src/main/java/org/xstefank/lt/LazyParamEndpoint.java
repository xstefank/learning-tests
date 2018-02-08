package org.xstefank.lt;

import org.xstefank.lt.model.ParamDummy;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.ext.ParamConverter;

@Path("/lazy")
@ParamConverter.Lazy
public class LazyParamEndpoint {

    @GET
    public String testQueryParam(@DefaultValue("Dummy{name=Default,age=42}") @QueryParam("param") ParamDummy param) {
        return "query param value= " + param;
    }

}
