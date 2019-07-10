package ru.kravchenko.tm;

import lombok.NonNull;
import ru.kravchenko.tm.bootstrap.Bootstrap;

/**
 * @author Roman Kravchenko
 */

public class App {

    public static void main(String[] args) throws Exception {
        @NonNull final Bootstrap bootstrap = new Bootstrap();
        bootstrap.init();
    }

}