package org.xstefank;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3);
        System.out.println(integers);

        Set<String> set = Set.of("A", "B", "C");
        System.out.println(set);

        Map<String, String> map = Map.of("key1", "val1", "key2", "val2");
        System.out.println(map);        
    }
    
}
