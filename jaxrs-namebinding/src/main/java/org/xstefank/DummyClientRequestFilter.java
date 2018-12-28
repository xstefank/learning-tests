package org.xstefank;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@TestBinding
public class DummyClientRequestFilter implements ClientRequestFilter {
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        System.out.println("YYYYYYYYYYYYYY + ClientRequestFilter");
    }
}
