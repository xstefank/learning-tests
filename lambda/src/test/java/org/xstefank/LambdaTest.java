package org.xstefank;

import org.junit.Before;
import org.junit.Test;
import org.xstefank.model.Executor;
import org.xstefank.model.SecurityDomain;

public class LambdaTest {
    
    private Executor executor;
    
    @Before
    public void beforeTest() {
        executor = new Executor();
    }
    
    @Test
    public void testDefaultConstructor() {
        executor.setPreviewCallback(SecurityDomain::new);
    }
    
}
