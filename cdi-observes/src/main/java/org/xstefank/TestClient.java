package org.xstefank;

import javax.ws.rs.GET;

@RegisterLRAParticipant
public interface TestClient {
    
    
    @GET
    String get();
}
