package org.xstefank;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class InternalErrorExceptionMapper implements ResponseExceptionMapper<WebApplicationException> {
    @Override
    public boolean handles(int status, MultivaluedMap<String, Object> headers) {
        return status == 500;
    }

    @Override
    public WebApplicationException toThrowable(Response response) {
        return new WebApplicationException("Custom mapper exception");
    }
}
