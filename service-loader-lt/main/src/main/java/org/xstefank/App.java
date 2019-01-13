package org.xstefank;

import java.util.Iterator;
import java.util.ServiceLoader;

public class App {

    public static void main(String[] args) {
        ServiceLoader<Dummy> loader = ServiceLoader.load(Dummy.class);

        Iterator<Dummy> iterator = loader.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().hello());
        }

        System.out.println("------------ done");
    }
    
}
