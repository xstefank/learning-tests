package org.xstefank;

import java.io.IOException;
import java.time.ZoneId;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("sleep", "2");
        Process process = processBuilder.start();
        ProcessHandle.Info info = process.info();

        System.out.printf("Process ID : %s%n", process.pid());
        System.out.printf("Command name : %s%n", info.command().orElse(""));
        System.out.printf("Command line : %s%n", info.commandLine().orElse(""));

        System.out.printf("Start time: %s%n",
                info.startInstant().map(i -> i.atZone(ZoneId.systemDefault())
                        .toLocalDateTime().toString()).orElse(""));

        System.out.printf("Arguments : %s%n",
                info.arguments().map(a -> Stream.of(a).collect(
                        Collectors.joining(" "))).orElse(""));

        System.out.printf("User : %s%n", info.user().orElse(""));

        process.onExit().thenRun(() -> System.out.println("Process " + process + "finished"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
