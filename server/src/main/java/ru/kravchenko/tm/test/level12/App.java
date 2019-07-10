package ru.kravchenko.tm.test.level12;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Roman Kravchenko
 */

public class App {

    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream resourceStream = App.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


        String url = properties.getProperty("url");
        System.out.println(url);
        System.out.println(properties.getProperty("password"));

    }

}
