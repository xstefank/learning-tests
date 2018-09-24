package org.learn.stuff8;

import java.util.Arrays;

public class PrintMain {

    public static void main(String[] args) {
        System.out.println("get prop - " + System.getProperty("foo"));
        System.out.println("args - " + Arrays.toString(args));
    }
}
