package org.xstefank;

import com.impetus.annovention.ClasspathDiscoverer;
import com.impetus.annovention.Discoverer;

public class App {
    public static void main(String[] args) {
        Discoverer discoverer = new ClasspathDiscoverer();

        discoverer.addAnnotationListener(new MyMethodAnnotationListener());

        System.out.println(discoverer.findResources());
    }
}
