package ru.kravchenko.tm.exception.exception;

/**
 * @author Roman Kravchenko
 */

public final class AccountNotFoundException extends Exception{

    public AccountNotFoundException() {
        super("Error! Account not found...");
    }

}
