package ru.kravchenko.tm;

import javafx.application.Application;
import lombok.NonNull;
import ru.kravchenko.tm.bootstrap.Bootstrap;

import javax.enterprise.inject.se.SeContainerInitializer;
import javax.enterprise.inject.spi.CDI;

/**
 * @author Roman Kravchenko
 */

public class App {

    public static void main(String[] args) throws Exception {
        SeContainerInitializer.newInstance() .addPackages(Application.class).initialize();
        @NonNull final Bootstrap bootstrap = CDI.current().select(Bootstrap.class).get();
        bootstrap.init();
    }

}