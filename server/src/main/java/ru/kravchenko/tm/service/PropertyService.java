package ru.kravchenko.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.App;
import ru.kravchenko.tm.api.service.IPropertyService;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Roman Kravchenko
 */

@ApplicationScoped
public class PropertyService implements IPropertyService {

    @NotNull
    private final Properties properties = new Properties();

    public PropertyService() {
        init();
    }

    private void init() {

        try (InputStream resourceStream = App.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        @Nullable final String port = System.getProperty("server.port");
        if (port != null && !port.isEmpty()) {
            properties.setProperty("server.port", port);
        }
        @Nullable final String host = System.getProperty("server.host");
        if (host != null && !host.isEmpty()) {
            properties.setProperty("server.host", host);
        }
    }

    @Override
    public String getServerHost() {
        return properties.getProperty("server.host");
    }

    @Override
    public String getServerPort() {
        return properties.getProperty("server.port");
    }

}
