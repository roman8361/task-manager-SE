package ru.kravchenko.tm.api;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.SessionNotFoundException_Exception;
import ru.kravchenko.tm.endpoint.UserNotFoundException_Exception;


/**
 * @author Roman Kravchenko
 */


public abstract class AbstractCommand {

    protected IEndpointServiceLocator serviceLocator;

    public abstract String getName();

    public abstract void getDescription();

    public abstract void execute() throws AccessForbiddenException_Exception, UserNotFoundException_Exception, SessionNotFoundException_Exception;

    public void setServiceLocator(@NotNull final IEndpointServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

}
