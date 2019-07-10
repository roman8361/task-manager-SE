package ru.kravchenko.tm;

import lombok.SneakyThrows;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Unit test for simple App.
 */

public class AppTest {
    public static void main(String[] args) throws ParseException {
        dateFormater(dateParser());
        //dateParser();
    }



    static void exampleDate1() throws ParseException {
        Date date = new Date();
       // System.out.println(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
      //  System.out.println(date);
    //    calendar.add(Calendar.WEEK_OF_MONTH,56);
       // System.out.println(calendar.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(simpleDateFormat.format(calendar.getTime()));

    //    Date newDate = simpleDateFormat.parse ("10/06/1983");
     //   System.out.println(newDate);
    }

    void exampleDate2() throws ParseException {
        final Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter date begin (dd/mm/yyyy)");
        final String nameProject = sc1.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date newDate = simpleDateFormat.parse (nameProject);
        System.out.println(newDate);
    }

    static void dateFormater(Date date) {
        String pattern = "dd.MM.yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date1 = simpleDateFormat.format(date);
        System.out.println(date1);

    }

    @SneakyThrows
    static Date dateParser() {
        String pattern = "dd.MM.yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date date = simpleDateFormat.parse("09.10.2019");
        return date;
    }

    @Test
    public void mainfest() {
//        String version = Manifests.read("Implementation-Version");
//        String developer = Manifests.read("Created-By");
//        System.out.println("Version: " + version);
//        System.out.println("Created by: " + developer);
    }

}
