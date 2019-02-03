package org.xstefank;

import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("A");
//        strings.add(null);
        List<String> collect = strings.stream()
                .map((@NotNull var s) -> s.toLowerCase())
                .collect(Collectors.toList());

        System.out.println(collect);
    }
    
}
