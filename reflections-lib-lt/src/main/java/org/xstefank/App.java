package org.xstefank;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Method;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
            .setUrls(ClasspathHelper.forPackage(""))
            .setScanners(new MethodAnnotationsScanner()));

        Set<Method> annotated = reflections.getMethodsAnnotatedWith(TestApp.class);

        System.out.println(annotated);
    }
    
}
