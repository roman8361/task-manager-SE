package ru.kravchenko.tm.command.additional;

import ru.kravchenko.tm.api.AbstractCommand;

/**
 * @author Roman Kravchenko
 */

public class AboutCommand extends AbstractCommand {

    @Override
    public String getName() { return "about"; }

    @Override
    public void getDescription() {
        System.out.println("Information about application");
    }

    @Override
    public void execute() {

    }

}
