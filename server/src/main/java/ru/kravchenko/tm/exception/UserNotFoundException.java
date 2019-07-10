package ru.kravchenko.tm.exception;

/**
 * @author Roman Kravchenko
 */

public final class UserNotFoundException extends UserNotCorrectInputException {

    public UserNotFoundException() {
        super("Error! User not found...");
    }

}
