package org.xstefank;

import org.eclipse.microprofile.lra.annotation.Compensate;
import org.eclipse.microprofile.lra.annotation.Complete;

@RegisterLRAParticipant(name = "TestParticipant")
public class TestClassClient {
    
    @Compensate
    public void compensate() {
        
    }
    
    @Complete
    public void complete() {
        
    }
}
