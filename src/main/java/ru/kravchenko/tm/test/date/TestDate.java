package ru.kravchenko.tm.test.date;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class TestDate {

    Date date;

    @Override
    public String toString() {
        String pattern = "dd.MM.yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date1 = simpleDateFormat.format(this.date);

        return "DATE: " +  date1;
    }



}
