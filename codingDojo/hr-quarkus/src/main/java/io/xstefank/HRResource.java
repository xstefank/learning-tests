package io.xstefank;

import io.xstefank.util.HRService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.lang.Math.floor;

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

    @GET
    @Path("java-currency-formatter")
    public void javaCurrencyProvider() throws Exception {
        Scanner scanner = new Scanner(hrService.getFile("javaCurrencyFormatter.txt"));

        double payment = scanner.nextDouble();
        scanner.close();

        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        String india = NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(payment);
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }

    @GET
    @Path("java-exception-handling")
    public void javaExceptionHandling() throws Exception {
        Scanner scanner = new Scanner(hrService.getFile("javaExceptionHandling.txt"));

        try {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            scanner.close();

            System.out.println(x / y);
        } catch (InputMismatchException e) {
            System.out.println(e.getClass().getName());
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @GET
    @Path("java-exception-handling2")
    public void javaExceptionHandling2() throws Exception {
        Scanner scanner = new Scanner(hrService.getFile("javaExceptionHandling2.txt"));
        MyCalculator myCalculator = new MyCalculator();

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int p = scanner.nextInt();

            try {
                long result = myCalculator.power(n, p);

                System.out.println(Math.pow(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        scanner.close();
    }

    private static final class MyCalculator {
        public long power(int n, int p) throws Exception {
            if (n < 0 || p < 0) {
                throw new Exception("n or p should not be negative.");
            }

            if (n == 0 && p == 0) {
                throw new Exception("n and p should not be zero.");
            }

            return (long) Math.pow(n, p);
        }
    }

    @GET
    @Path("staircase")
    public void staircase() throws Exception {
        Scanner scanner = new Scanner(hrService.getFile("staircase.txt"));

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(String.format("%1$" + n + "s", getNHashes(i + 1)));
        }

        scanner.close();
    }

    private String getNHashes(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append("#");
        }

        return sb.toString();
    }

    @GET
    @Path("min-max-sum")
    public void minMaxSum() throws Exception {
        Scanner scanner = new Scanner(hrService.getFile("min-max-sum.txt"));

        int[] arr = new int[5];
        
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }

    private void miniMaxSum(int[] arr) {
        long[] sums = new long[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            sums[i] = getSumWithoutNthElement(arr, i);
        }

        System.out.println(LongStream.of(sums).min().getAsLong() + " " + LongStream.of(sums).max().getAsLong());
    }

    private long getSumWithoutNthElement(int[] arr, int n) {
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i == n) {
                continue;
            }

            sum += arr[i];
        }

        return sum;
    }

    @GET
    @Path("birthday-candles")
    public void birthdayCandles() throws Exception {
        Scanner scanner = new Scanner(hrService.getFile("birthday-candles.txt"));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);

        System.out.println(result);

        scanner.close();
    }

    private static int birthdayCakeCandles(int[] ar) {
        int count = 0;
        int currentMax = 0;

        for (int i : ar) {
            if (i > currentMax) {
                currentMax = i;
                count = 1;
            } else if (i == currentMax) {
                count++;
            }
        }

        return count;
    }

    @GET
    @Path("time-conversion")
    public void timeConversionREST() throws Exception {
        Scanner scanner = new Scanner(hrService.getFile("time-conversion.txt"));

        String s = scanner.nextLine();
        String result = timeConversion(s);

        System.out.println(result);

        scanner.close();
    }

    private String timeConversion(String s) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm:ssa");
        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");

        Date date = inputFormat.parse(s);
        return outputFormat.format(date);
    }

    @GET
    @Path("grading-students")
    public void gradingStudents() throws Exception {
        Scanner scanner = new Scanner(hrService.getFile("grading-students.txt"));

        int n = scanner.nextInt();
        List<Integer> grades = new ArrayList<>(n);
        
        IntStream.range(0, n).forEach(value -> grades.add(scanner.nextInt()));

        List<Integer> correctedGrades = grades.stream().map(grade -> {
            if (grade < 38) {
                return grade;
            }

            int mod = grade % 5;
            if (mod >= 3) {
                return grade + (5 - mod);
            } else {
                return grade;
            }
        }).collect(Collectors.toList());

        System.out.println(correctedGrades);

        scanner.close();
    }

    @GET
    @Path("apples-and-oranges")
    public void applesAndOranges() throws Exception {
        Scanner scanner = new Scanner(hrService.getFile("apples-and-oranges.txt"));

        int s = scanner.nextInt();
        int t = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] apples = new int[n];
        
        IntStream.range(0, n).forEach(i -> {
            apples[i] = scanner.nextInt();
        });

        int[] oranges = new int[m];

        IntStream.range(0, m).forEach(i -> {
            oranges[i] = scanner.nextInt();
        });

        countApplesAndOranges(s, t, a, b, apples, oranges);

        scanner.close();
    }

    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int appleHitCount = 0;
        hitCount(s, t, a, apples);

        int orangeHitCount = 0;
        hitCount(s, t, b, oranges);
    }

    private static void hitCount(int s, int t, int treePos, int[] fruit) {
        int hitCount = 0;
        
        for (int d : fruit) {
            int pos = treePos + d;
            if (pos >= s && pos <= t) {
                hitCount++;
            }
        }

        System.out.println(hitCount);
    }
    
    @GET
    @Path("kangaroo")
    public void kangarooREST() throws Exception {
        Scanner scanner = new Scanner(hrService.getFile("kangaroo.txt"));

        int x1 = scanner.nextInt();
        int v1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int v2 = scanner.nextInt();

        System.out.println(kangaroo(x1, v1, x2, v2));


        scanner.close();
    }

    private static String kangaroo(int x1, int v1, int x2, int v2) {
        if(v2 >= v1 && x1 != x2){
            return "NO";
        }
        
        float x = (float)(x2 - x1) / (v1 - v2);

        if (floor(x) == x) {
            return "YES";
        } else {
            return "NO";
        }
    }

    @GET
    @Path("between-two-sets")
    public void betweenTwoSetsREST() throws Exception {
        Scanner scanner = new Scanner(hrService.getFile("between-two-sets.txt"));

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Integer> firstList = new ArrayList<>(n);
        List<Integer> secondList = new ArrayList<>(m);

        IntStream.range(0, n).forEach(i -> firstList.add(scanner.nextInt()));
        IntStream.range(0, m).forEach(i -> secondList.add(scanner.nextInt()));

        System.out.println(getTotalX(firstList, secondList));

        scanner.close();
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int count = 0;

        int min = Collections.min(a);
        int max = Collections.max(b);

        for (int i = min; i <= max; i++) {
            if (areAllFactor(i, a) && isFactorOfAll(i, b)) {
                count++;
            }
        }
        
        return count;
    }

    private static boolean areAllFactor(int i, List<Integer> integers) {
        return integers.stream().allMatch(integer -> i % integer == 0);
    }

    private static boolean isFactorOfAll(int i, List<Integer> integers) {
        return integers.stream().allMatch(integer -> integer % i == 0);
    }

}
