package org.xstefank;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit((Callable<String>) () -> {
            try {
                Thread.sleep(3000);
                return "Hello world!";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            return null;
        });

        try {
            System.out.println(future.get(-1, TimeUnit.SECONDS));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}
