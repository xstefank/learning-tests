package io.xstefank;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("foo", "bar");
        map.computeIfAbsent("foo1", s -> "asdfasdf");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
}
