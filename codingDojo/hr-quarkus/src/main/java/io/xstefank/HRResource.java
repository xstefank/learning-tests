package io.xstefank;

import io.xstefank.util.HRService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.IntStream;

@Path("/hr")
public class HRResource {

    @Inject
    HRService hrService;


    @GET
    @Path("/input")
    public void input() throws IOException, URISyntaxException {

        Scanner scanner = new Scanner(hrService.getFile("input.txt"));

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        scanner.close();
        hrService.outputDelimeter();
    }

    @GET
    @Path("/ifElse")
    public void ifElse() throws IOException {
        Scanner scanner = new Scanner(hrService.getFile("ifElse.txt"));

        int n = scanner.nextInt();

        if (n % 2 == 1) {
            System.out.println("Weird");
        } else if (n >= 2 && n <= 5) {
            System.out.println("Not Weird");
        } else if (n >= 6 && n <= 20) {
            System.out.println("Weird");
        } else {
            System.out.println("Not Weird");
        }

        scanner.close();
        hrService.outputDelimeter();
    }

    @GET
    @Path("stdII")
    public void stdII() throws IOException {
        Scanner scanner = new Scanner(hrService.getFile("stdII.txt"));

        int i = scanner.nextInt();
        double d = scanner.nextDouble();
        scanner.nextLine();
        String s = scanner.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);

        scanner.close();
        hrService.outputDelimeter();
    }

    @GET
    @Path("outputFormatting")
    public void outputFormatting() throws IOException {
        Scanner sc = new Scanner(hrService.getFile("outputFormatting.txt"));
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            System.out.printf("%-15s%03d%n", s1, x);
        }
        System.out.println("================================");
    }

    @GET
    @Path("loops1")
    public void loops1() throws IOException {
        Scanner scanner = new Scanner(hrService.getFile("loops1.txt"));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        IntStream.rangeClosed(1, 10)
            .forEach(i -> System.out.printf("%d x %d = %d%n", n, i, n * i));

        scanner.close();
    }

    @GET
    @Path("loops2")
    public void loops2() throws IOException {
        Scanner scanner = new Scanner(hrService.getFile("loops2.txt"));

        int q = scanner.nextInt();
        IntStream.range(0, q).forEach(i -> {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();

            printEquation(a, b, n);
            System.out.println();
        });
    }

    private void printEquation(int a, int b, int n) {
        IntStream.rangeClosed(0, n - 1)
            .forEach(i -> System.out.printf("%d ", a + getBSum(i, b)));
    }

    private int getBSum(int max, int b) {
        return IntStream.rangeClosed(0, max)
            .reduce(0, (acc, i) -> (int) (acc + (Math.pow(2, i) * b)));
    }

    @GET
    @Path("java-datatypes")
    public void javaDatatypes() throws IOException {
        Scanner scanner = new Scanner(hrService.getFile("java-datatypes.txt"));
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            try {
                long x = scanner.nextLong();
                System.out.println(x + " can be fitted in:");
                if (x >= -128 && x <= 127) System.out.println("* byte");
                if (x >= -32768 && x <= 32767) System.out.println("* short");
                if (x >= (-1 * Math.pow(2, 31)) && x <= (Math.pow(2, 31) - 1)) System.out.println("* int");
                if (x >= (-1 * Math.pow(2, 63)) && x <= (Math.pow(2, 63) - 1)) System.out.println("* long");
            } catch (Exception e) {
                System.out.println(scanner.next() + " can't be fitted anywhere.");
            }

        }
    }
    
    @GET
    @Path("java-end-of-file")
    public void javaEndOfFile() throws IOException {
        int counter = 0;

        Scanner scanner = new Scanner(hrService.getFile("java-end-of-file.txt"));

        while (scanner.hasNext()) {
            System.out.printf("%d %s%n", ++counter, scanner.nextLine());
        }
    }
    
    @GET
    @Path("date-and-time")
    public void javaDayAndTime() throws IOException {
        Scanner scanner = new Scanner(hrService.getFile("java-date-and-time.txt"));

        int month = scanner.nextInt();
        int day = scanner.nextInt();
        int year = scanner.nextInt();

        System.out.println(LocalDate.of(year, month, day).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US));
    }

}
