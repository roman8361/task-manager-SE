package ru.kravchenko.tm.command.task;

import ru.kravchenko.tm.api.AbstractCommand;

/**
 * @author Roman Kravchenko
 */
public class TaskDumpCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "task-dump";
    }

    @Override
    public void getDescription() {
        System.out.println("task-dump: Save task date form repository in disk");
    }

    @Override
    public void execute() {

    }

}


