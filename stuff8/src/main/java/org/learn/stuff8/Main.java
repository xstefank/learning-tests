package org.learn.stuff8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
//        arrays();
//        regex();
        iterator();
    }

    public static void arrays() {
        String[] stringArray = new String[10];

        System.out.println(Arrays.toString(stringArray));

        for (String string : stringArray) {
            System.out.println(string);
        }

        System.out.println("----------------- object");
        Object[] objectArray = new Object[10];

        System.out.println(Arrays.toString(objectArray));


    }

    public static void regex() {
        String test = "foo1:8080/api";
        Pattern pattern = Pattern.compile("^(.*/api).*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(test);

        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }

    public static void iterator() {

        //Arrays.asList() returns a list backed by an original array
        List<String> testCollection = new ArrayList<>(Arrays.asList("a", "b", "c"));

        System.out.println(testCollection);

        Iterator<String> iterator = testCollection.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.equals("b")) {
                iterator.remove();
            }
        }

        System.out.println(testCollection);
    }
}
