package ru.kravchenko.tm.exception;

/**
 * @author Roman Kravchenko
 */

public class ProjectNotFoundException extends UserNotCorrectInputException {

    public ProjectNotFoundException() {
        super("Error! Project not found...");
    }

}
