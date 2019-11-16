package io.xstefank;

import io.xstefank.util.HRService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Path("/")
public class Resource {

    @Inject
    HRService hrService;

    @GET
    @Path("simple-array-sum")
    public Object simpleArraySim() throws Exception {
        Scanner scanner = new Scanner(hrService.getStream("simple-array-sum.txt"));

        int n = scanner.nextInt();
        int[] ints = new int[n];

        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }

        return IntStream.of(ints).sum();
    }

    @GET
    @Path("compare-triplets")
    public Object compareTriplets() throws Exception {
        Scanner scanner = new Scanner(hrService.getStream("compare-triplets.txt"));

        List<Integer> a = new ArrayList<>(3);
        List<Integer> b = new ArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            a.add(scanner.nextInt());
        }

        for (int i = 0; i < 3; i++) {
            b.add(scanner.nextInt());
        }

        scanner.close();

        List<Integer> result = Arrays.asList(0, 0);

        // compare triplets
        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                result.set(0, result.get(0) + 1);
            } else if (a.get(i) < b.get(i)) {
                result.set(1, result.get(1) + 1);
            }
        }

        return result.toString();
    }

    @GET
    @Path("very-big-sum")
    public Object veryBigSum() {
        Scanner scanner = new Scanner(hrService.getStream("very-big-sum.txt"));

        int n = scanner.nextInt();
        LongStream.Builder values = LongStream.builder();
        for (int i = 0; i < n; i++) {
            values.add(scanner.nextLong());
        }
         
        return values.build().sum();
    }
    
    @GET
    @Path("diagonal-difference")
    public Object diagonalDifference() {
        Scanner scanner = new Scanner(hrService.getStream("diagonal-difference.txt"));

        int n = scanner.nextInt();
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> integers;
            integers = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                integers.add(scanner.nextInt());
            }

            arr.add(integers);
        }
        
        int forwardDiagonal = 0;
        
        for (int i = 0; i < n; i++) {
            forwardDiagonal += arr.get(i).get(i);
        }
        
        int backwardDiagonal = 0;

        for (int i = 0; i < n; i++) {
            backwardDiagonal += arr.get(i).get(n - i - 1);
        }

        return Math.abs(forwardDiagonal - backwardDiagonal);
    }
}
