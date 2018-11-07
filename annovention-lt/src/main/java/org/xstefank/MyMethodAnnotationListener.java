package org.xstefank;

import com.impetus.annovention.listener.MethodAnnotationDiscoveryListener;

public class MyMethodAnnotationListener implements MethodAnnotationDiscoveryListener {
    public void discovered(String clazz, String method, String annotation) {
        System.out.println("clazz = " + clazz);
        System.out.println("metjod = " + method);
        System.out.println("annotation = " + annotation);
    }

    public String[] supportedAnnotations() {
        return new String[] {TestAnn.class.getName()};
    }
}
