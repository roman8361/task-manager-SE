package ru.kravchenko.tm.api;

import ru.kravchenko.tm.exception.UserLoginBusyException;

/**
 * @author Roman Kravchenko
 */

public abstract class AbstractCommand {

    public abstract String getName();

    public abstract void getDescription();

    public abstract void execute() throws UserLoginBusyException;

}
