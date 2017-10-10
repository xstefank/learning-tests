package org.learn.stuff8;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] stringArray = new String[10];

        System.out.println(Arrays.toString(stringArray));

        for (String string : stringArray) {
            System.out.println(string);
        }

        System.out.println("----------------- object");
        Object[] objectArray = new Object[10];

        System.out.println(Arrays.toString(objectArray));


    }
}
