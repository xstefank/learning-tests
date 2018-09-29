package org.learn.hr.javaPriorityQueue;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    private final static Scanner scan = new Scanner(ClassLoader.getSystemResourceAsStream("javaPriorityQueue.txt"));
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
    
    private static final class Student implements Comparable<Student> {

        private static final Comparator<Student> COMPARATOR =
                Comparator.comparingDouble(Student::getCgpa).reversed()
                        .thenComparing(Student::getName)
                        .thenComparing(Student::getId);
        
        private int id;
        private String name;
        private double cgpa;

        public Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        @Override
        public int compareTo(Student student) {
            return COMPARATOR.compare(this, student);
        }
    }
    
    private static final class Priorities {
        
        List<Student> getStudents(List<String> events) {
            PriorityQueue<Student> studentQueue = new PriorityQueue<>();
            
            for (String event : events) {
                Scanner scanner = new Scanner(event);
                String action = scanner.next();
                if (action.equals("ENTER")) {
                    String name = scanner.next();
                    double cgpa = scanner.nextDouble();
                    int id = scanner.nextInt();
                    studentQueue.add(new Student(id, name, cgpa));
                } else {
                    studentQueue.poll();
                }
            }

            List<Student> resultList = new ArrayList<>();
            int size = studentQueue.size();
            for (int i = 0; i < size; i++) {
                resultList.add(studentQueue.poll());
            }
            
            return resultList;
        }
    }
}
