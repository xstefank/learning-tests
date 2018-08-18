package org.learn.hr.javaRegex;

import java.util.Scanner;

class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("javaRegex1.txt"));
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}
