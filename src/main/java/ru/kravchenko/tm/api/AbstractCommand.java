package ru.kravchenko.tm.api;

/**
 * @author Roman Kravchenko
 */

public abstract class AbstractCommand {

    public abstract String getName();

    public abstract void getDescription();

    public abstract void execute();

}
