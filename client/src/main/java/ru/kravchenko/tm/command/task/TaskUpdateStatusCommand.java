package ru.kravchenko.tm.command.task;

import ru.kravchenko.tm.api.AbstractCommand;

/**
 * @author Roman Kravchenko
 */
public class TaskUpdateStatusCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "task-update-status";
    }

    @Override
    public void getDescription() {
        System.out.println("task-update-status: Update project status by id.");
    }

    @Override
    public void execute() {  }

}
