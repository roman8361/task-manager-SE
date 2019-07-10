package ru.kravchenko.tm.config;
import ru.kravchenko.tm.App;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Roman Kravchenko
 */
public class DefaultConfig extends Config {

    {
        Properties properties = new Properties();
        try (InputStream resourceStream = App.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        setDriveName(properties.getProperty("driver"));
        setDatabaseType(properties.getProperty("type"));
        setDatabaseName(properties.getProperty("name"));
        setHost(properties.getProperty("host"));
        setUsername(properties.getProperty("user"));
        setPassword(properties.getProperty("password"));
        setPort(Integer.valueOf(properties.getProperty("port")));
    }

}
