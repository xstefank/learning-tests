package io.xstefank;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Consumes("application/useless")
public class DummyMessageBodyTextPlain implements MessageBodyReader<String> {
    
    @Override
    public boolean isReadable(Class<?> aClass, Type type,
                              Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public String readFrom(Class<String> aClass, Type type, Annotation[] annotations,
                           MediaType mediaType, MultivaluedMap<String,String> multivaluedMap,
                           InputStream inputStream) throws IOException, WebApplicationException {
        return "Some string data";
    }
}
