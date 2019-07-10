package ru.kravchenko.tm.exception;

/**
 * @author Roman Kravchenko
 */

public class TaskNotFoundException extends UserNotCorrectInputException {

    public TaskNotFoundException() { super("Error. Task not found."); }

}
