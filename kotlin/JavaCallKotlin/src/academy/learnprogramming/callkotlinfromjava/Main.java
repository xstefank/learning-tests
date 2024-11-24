package academy.learnprogramming.callkotlinfromjava;

import academy.learnprogramming.kotlincode.Challenge;
import academy.learnprogramming.kotlincode.Employee;
import academy.learnprogramming.kotlincode.KotlinCodeKt;

public class Main {

    public static void main(String[] args) {

//        KotlinStuff.sayHelloToJava("Student");
//
//        Employee employee = new Employee("John", "Smith", 2010);
//        employee.startYear = 2009;
//
//        Challenge.doMath(5, 4);
//
//        employee.takesDefault("arg1");

        KotlinCodeKt.sayHelloToJava("Student");

        Employee employee = new Employee("John", "Smith", 2010);
        employee.setStartYear(2009);

        Challenge.INSTANCE.doMath(5, 4);

        employee.takesDefault(null);

//        employee.takesDefault("arg1");
    }
}
