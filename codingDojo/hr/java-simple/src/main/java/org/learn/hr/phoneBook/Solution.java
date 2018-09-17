package org.learn.hr.phoneBook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Map<String, Integer> phoneNumbers = new HashMap<>();
        
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("phoneBook.txt"));
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            phoneNumbers.put(name, phone);
            in.nextLine();
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            Integer phoneNumber = phoneNumbers.get(s);
            System.out.println(phoneNumber != null ? s + "=" + phoneNumber : "Not found");
            
        }
    }
}
