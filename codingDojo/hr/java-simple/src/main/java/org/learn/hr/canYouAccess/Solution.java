package org.learn.hr.canYouAccess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.Permission;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) throws Exception {
        DoNotTerminate.forbidExit();

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("canYouAccess.txt")));
            int num = Integer.parseInt(br.readLine().trim());
            Object o;

            Constructor<Inner.Private> ctor = Inner.Private.class.getDeclaredConstructor(Inner.class);
            ctor.setAccessible(true);
            o = ctor.newInstance(new Inner());

            Method powerof2 = o.getClass().getDeclaredMethod("powerof2", Integer.TYPE);
            powerof2.setAccessible(true);
            System.out.println(Integer.toString(num) + " is " + powerof2.invoke(o, num));

            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

        }//end of try

        catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }//end of main
    static class Inner{
        private class Private{
            private String powerof2(int num){
                return ((num&num-1)==0)?"power of 2":"not a power of 2";
            }
        }
    }//end of Inner

}//end of Solution

class DoNotTerminate { //This class prevents exit(0)

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}	
