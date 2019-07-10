package ru.kravchenko.tm;

import lombok.NonNull;
import ru.kravchenko.tm.bootstrap.Bootstrap;
import ru.kravchenko.tm.exception.UserNotFoundException;

/**
 * @author Roman Kravchenko
 */

public class App {

    public static void main(String[] args) throws UserNotFoundException {
        @NonNull final Bootstrap bootstrap = new Bootstrap();
        bootstrap.init();
    }

}