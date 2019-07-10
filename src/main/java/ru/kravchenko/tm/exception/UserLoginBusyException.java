package ru.kravchenko.tm.exception;

/**
 * @author Roman Kravchenko
 */
public class UserLoginBusyException extends UserNotCorrectInputException {
    public UserLoginBusyException() {
        super("Login is busy, please change login");
    }

}
