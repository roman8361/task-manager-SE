package ru.kravchenko.tm.test.level07;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

public class App {

    public static void main(String[] args) {
        Map <String, String> test = new LinkedHashMap<>();
        test.put("1", "22");
        test.put("2", "23");
        test.put("3", "24");
        test.put("4", "25");
        test.put("5", "26");

        System.out.println(test);

        test.remove("1");
        System.out.println(test);
    }
}
