package ru.kravchenko.tm;


import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kravchenko.tm.bootstrap.AppConfig;
import ru.kravchenko.tm.bootstrap.Bootstrap;

/**
 * @author Roman Kravchenko
 */

public class App {

    @SneakyThrows
    public static void main(String[] args) {
        @NotNull final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        @NotNull final Bootstrap bootstrap = context.getBean(Bootstrap.class);
        bootstrap.init();
    }

}