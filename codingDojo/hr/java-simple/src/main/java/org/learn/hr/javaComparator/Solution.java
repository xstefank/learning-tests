package org.learn.hr.javaComparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(ClassLoader.getSystemResourceAsStream("javaComparator.txt"));
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }

    private static final class Checker implements Comparator<Player> {
        
        @Override
        public int compare(Player p1, Player p2) {
            int scoreCompare = Integer.compare(p1.score, p2.score);
            if (scoreCompare != 0) return -scoreCompare;

            return p1.name.compareTo(p2.name);
        }
        
        
    }
    

    private static final class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
