package ru.kravchenko.tm.api;

import org.jetbrains.annotations.NotNull;


/**
 * @author Roman Kravchenko
 */

public abstract class AbstractCommand {

    protected IEndpointServiceLocator serviceLocator;

    public abstract String getName();

    public abstract void getDescription();

    public abstract void execute() throws Exception;

    public void setServiceLocator(@NotNull final IEndpointServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

}
