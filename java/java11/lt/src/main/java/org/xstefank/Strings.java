package org.xstefank;

public class Strings {

    public static void main(String[] args) {
        System.out.println(" ".isBlank());
        System.out.println(" ".isEmpty());
        "a\nb\nc\n".lines().forEach(System.out::println);
        System.out.println("foo".repeat(3));
        System.out.println(" foo ".strip());
    }
}
