package org.learn.stuff8;

import java.io.File;
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
//        iterator();
//        regex2();
//        files();
//        regex3();
//        retianAllTest();
        regex4();
    }

    private static void regex4() {
        Pattern pattern = Pattern.compile("Upstream issue: (<TICKET>|Upstream not required)");
        Matcher matcher = pattern.matcher("Upstream issue: Upstream not required");

        System.out.println(matcher.matches());

    }

    private static void retianAllTest() {
        List<String> list1 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        List<String> list2 = Arrays.asList("y", "z", "x");

        list1.retainAll(list2);
        System.out.println(list1);
    }

    private static void regex3() {
        Pattern pattern = Pattern.compile("Dummy\\{name=(.*?),age=(.*?)}");
        Matcher matcher = pattern.matcher("Dummy{name=Default,age=42}");
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }

    private static void files() {
        File f = new File("./test.txt");
        System.out.println(f.isAbsolute());
        System.out.println(f.getAbsoluteFile().getAbsolutePath());
    }

    private static void regex2() {
        String s = "foo | bar bar";
        System.out.println(removeSpacesAfter(s, '|'));
    }

    private static String removeSpacesAfter(String s, Character character) {
        return s.replaceAll("\\|\\s+", "|");
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
