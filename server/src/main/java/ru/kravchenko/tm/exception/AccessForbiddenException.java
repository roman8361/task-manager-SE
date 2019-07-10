package ru.kravchenko.tm.exception;

/**
 * @author Roman Kravchenko
 */

public class AccessForbiddenException extends Exception {

    public AccessForbiddenException(final String message) { super("Access Forbidden Exception"); }

}
