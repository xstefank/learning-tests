package org.learn.hr.intToString;

import java.security.Permission;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        DoNotTerminate.forbidExit();

        try {
            Scanner in = new Scanner(Solution.class.getClassLoader().getResourceAsStream("intToString1.txt"));
            int n = in.nextInt();
            in.close();

            String s = Integer.toString(n);

            if (n == Integer.parseInt(s)) {
                System.out.println("Good job");
            } else {
                System.out.println("Wrong answer.");
            }
        } catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }

    private static class DoNotTerminate {

        private static class ExitTrappedException extends SecurityException {
            private static final long serialVersionUID = 1;
        }

        public static void forbidExit() {
            final SecurityManager securityManager = new SecurityManager() {

                @Override
                public void checkPermission(Permission perm) {
                    if (perm.getName().contains("exitVM")) {
                        throw new ExitTrappedException();
                    }
                }
            };

            System.setSecurityManager(securityManager);
        }
    }
}
