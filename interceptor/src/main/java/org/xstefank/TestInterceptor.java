package org.xstefank;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@TestAction
@Interceptor
public class TestInterceptor {
    
    @AroundInvoke
    public Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("XXXXXXXXXXXXXXXXXXX around invoke");
        
        context.setParameters(new Object[]{"TestLRAId"});
        
        Object ret = context.proceed();

        System.out.println("XXXXXXXXXXXXXXXX after invoke" + context);
        
        return ret;
    }
}
