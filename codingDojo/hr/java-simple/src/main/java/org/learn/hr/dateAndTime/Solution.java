package org.learn.hr.dateAndTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(Solution.class.getClassLoader().getResourceAsStream("dateAndTime1.txt"));
        String month = in.next();
        String day = in.next();
        String year = in.next();

        System.out.println(getDay(day, month, year));
    }

    private static String getDay(String day, String month, String year) {
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
        try {
            date = format.parse(day + month + year);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        cal.setTime(date);
        
        switch (cal.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                return "SUNDAY";
            case 2:
                return "MONDAY";
            case 3:
                return "TUESDAY";
            case 4:
                return "WEDNESDAY";
            case 5:
                return "THURSDAY";
            case 6:
                return "FRIDAY";
            case 7:
                return "SATURDAY";
            default:
                return "";
        }
    }


}
