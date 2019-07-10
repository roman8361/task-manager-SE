package ru.kravchenko.tm.exception;

/**
 * @author Roman Kravchenko
 */

public class SessionNotFoundException extends UserNotCorrectInputException {

    public SessionNotFoundException() {
        super("Error! Session not found...");
    }

}

