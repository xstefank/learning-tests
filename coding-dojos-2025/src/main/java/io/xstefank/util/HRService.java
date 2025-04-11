package io.xstefank.util;

import jakarta.enterprise.context.ApplicationScoped;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@ApplicationScoped
public class HRService {


    public Path getFile(String fileName) {
        URL resource = this.getClass().getClassLoader().getResource("META-INF/resources/" + fileName);

        try {
            return Paths.get(resource.toURI());
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public static List<Integer> readList(Scanner scanner, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        return list;
    }

    public static void printDelimeter() {
        System.out.println("\n--------------------------------------\n");
    }
}
