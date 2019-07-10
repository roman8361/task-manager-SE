package ru.kravchenko.tm.command.additional;

import ru.kravchenko.tm.api.AbstractCommand;

/**
 * @author Roman Kravchenko
 */

public class ExitCommand extends AbstractCommand {

    @Override
    public String getName() { return "exit"; }

    @Override
    public void getDescription() { System.out.println("exit: Exit"); }

    @Override
    public void execute() {
        System.out.println("Come back later...");
        System.exit(0);
    }

}
