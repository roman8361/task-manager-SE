package ru.kravchenko.tm.test.date;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Roman Kravchenko
 */
public class MainDate {

    public static void main(String[] args) {
        TestDate testDate = new TestDate();
        Date date = new Date();
        testDate.setDate(date);
        System.out.println(testDate);
    }

}
