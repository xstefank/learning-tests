package io.xstefank;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.ws.rs.core.Response;

public class MyResponseExceptionMapper implements ResponseExceptionMapper<SomeException> {
    @Override
    public SomeException toThrowable(Response response) {
        return new SomeException();
    }
}
