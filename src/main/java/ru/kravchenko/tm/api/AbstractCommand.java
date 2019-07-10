package ru.kravchenko.tm.api;

/**
 * @author Roman Kravchenko
 */

public abstract class AbstractCommand {

    public String getName() { return ""; }

    public void getDescription() {}

    public void execute() {}

}
