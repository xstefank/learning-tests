package org.xstefank.lt;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
        File dir = new File("src/main/org/xstefank/lt");
        URL url = dir.toURI().toURL();
        ClassLoader loader = new URLClassLoader(new URL[]{url});
        ClassLoader contextLoader = Thread.currentThread().getContextClassLoader();

        String className = CustomClass.class.getName();
        Class c1 = loader.loadClass(className);
        Class c2 = contextLoader.loadClass(className);

        System.out.println("classloaders equal - " + loader.equals(contextLoader));
        System.out.println("equals - " + c1.equals(c2));
        System.out.println("== - " + (c1 == c2));
        System.out.println("hashcode c1 - " + c1.hashCode());
        System.out.println("hashcode c2 - " + c2.hashCode());

        Map<Class<?>, String> classes = new HashMap<>();
        classes.put(c1, "random string");

        System.out.println(classes.get(c2));
    }
}
