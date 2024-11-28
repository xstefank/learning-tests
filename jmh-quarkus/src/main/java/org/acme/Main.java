package org.acme;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

import java.io.IOException;

@QuarkusMain
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Running app");
        Quarkus.run(args);

//        org.openjdk.jmh.Main.main(args);
    }
}
