package org.xstefank.lt;

import java.util.ServiceLoader;

public class Main {

    private static ServiceLoader<MyService> myServiceLoader = ServiceLoader.load(MyService.class, Main.class.getClassLoader());

    public static void main(String[] args) {
        getMyService();
    }

    private static void getMyService() {
        for (MyService myService : myServiceLoader) {
            System.out.println(myService.getName());
        }
    }
}
