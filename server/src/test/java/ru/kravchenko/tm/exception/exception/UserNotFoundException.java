package ru.kravchenko.tm.exception.exception;

/**
 * @author Roman Kravchenko
 */

public final class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("Error! User not found...");
    }

}
