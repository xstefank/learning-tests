package io.xstefank;

import javax.inject.Inject;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class ClientFilter implements ClientRequestFilter, ClientResponseFilter {

    @Inject
    MyRequestScopedBean myRequestScopedBean;

    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        System.out.println("Client request " + myRequestScopedBean.getUuid());
    }

    public void filter(ClientRequestContext clientRequestContext, ClientResponseContext clientResponseContext) throws IOException {
        System.out.println("Client response " + myRequestScopedBean.getUuid());
    }
}
