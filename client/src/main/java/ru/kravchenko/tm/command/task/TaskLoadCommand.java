package ru.kravchenko.tm.command.task;

import ru.kravchenko.tm.api.AbstractCommand;

/**
 * @author Roman Kravchenko
 */

public class TaskLoadCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "task-load";
    }

    @Override
    public void getDescription() {
        System.out.println("task-load: Load task form disk to repository");
    }

    @Override
    public void execute() {

    }

}
