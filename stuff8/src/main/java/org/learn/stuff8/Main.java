package org.learn.stuff8;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.core.UriBuilder;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
//        regex4();
//        regex5();
//        regex6();
//        url();
//        regex7();
        json();
    }

    private static void json() {
        File configFile = new File("src/main/resources/test.json");
        ObjectMapper mapper = new ObjectMapper();

        try {
            System.out.println(mapper.readValue(configFile, new TypeReference<Map<String, Object>>() {}).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void regex7() {
        Pattern pattern = Pattern.compile("\\[WFLY-\\d+\\]\\s+.*|WFLY-\\d+\\s+.*");
        Matcher matcher = pattern.matcher("WFLY-999999 Testing issue");

        System.out.println(matcher.matches());
    }

    private static void url() {
        try {
            URL url = new URL("http://localhost:8080/api");
            System.out.println(url.toString());

            URL path = new URL(url, "/request");
            System.out.println(path.toString());

            URI path2 = UriBuilder.fromUri(url.toURI())
                    .path("/request")
                    .build();
            System.out.println(path2);

            URI ip = new URL("http://172.19.0.5:8080").toURI();
            System.out.println(ip);
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static void regex6() {
        String s = "Upstream Issue: https://issues.jboss.org/browse/WFLY-42\n" +
                "Upstream PR: #13\n" +
                "Issue: https://issues.jboss.org/browse/JBEAP-43";

        Pattern pattern = Pattern.compile("Upstream Issue: (https://issues.jboss.org/browse/WFLY-\\d+|Upstream not required)\n" +
                "Upstream PR: #\\d+\n" +
                "Issue: https://issues.jboss.org/browse/JBEAP-\\d+");
        Matcher matcher = pattern.matcher(s);
        System.out.println(matcher.matches());
    }

    private static void regex5() {
        String line = "sadf dsaf 3000)! OK?";
        Pattern pattern = Pattern.compile("(.*\\))(.*)");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            System.out.println("group 1: " + matcher.group(1));
            System.out.println("group 2: " + matcher.group(2));
            System.out.println("group 3: " + matcher.group(3));
        }
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
