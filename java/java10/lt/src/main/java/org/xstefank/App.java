package org.xstefank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
//        localVarInference();
//        copyOf();
//        toUnmodifiable();
//        orElseThrow();
        
    }

    private static void orElseThrow() {
        Object o = Optional.empty().orElseThrow();
    }

    private static void toUnmodifiable() {
        List<Integer> ints = List.of(1, 2, 3);
        List<Integer> ints2 = ints.stream().collect(Collectors.toUnmodifiableList());
//        ints2.add(4);
    }

    private static void copyOf() {
        List<String> list = List.of("a", "b", "c");
        var copy = List.copyOf(list);
//        copy.add("d");
    }

    private static void localVarInference() {
        var string = "Hello";
        System.out.println("String var: " + string.getClass());

        var arrayList = new ArrayList<>();
        System.out.println("ArrayList var: " + arrayList.getClass());
        arrayList.add(1);

        var stringList = new ArrayList<String>();
        System.out.println("String list var: " + stringList.getClass());
        stringList.add("1");
    }

}
