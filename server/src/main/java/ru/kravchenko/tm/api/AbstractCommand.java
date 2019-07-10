package ru.kravchenko.tm.api;

import lombok.Setter;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.exception.UserLoginBusyException;

/**
 * @author Roman Kravchenko
 */


public abstract class AbstractCommand {

    @Setter
    public IServiceLocator serviceLocator;

    public abstract String getName();

    public abstract void getDescription();

    public abstract void execute() throws UserLoginBusyException;

}
