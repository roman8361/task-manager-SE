package ru.kravchenko.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.Session;
import ru.kravchenko.tm.endpoint.Task;
import ru.kravchenko.tm.endpoint.TaskEndpoint;

import java.util.Collection;

/**
 * @author Roman Kravchenko
 */

public class TaskReadCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "task-list";
    }

    @Override
    public void getDescription() {
        System.out.println("Command: task-list");
    }

    @Override
    public void execute(){
        @NotNull final TaskEndpoint taskEndpoint = serviceLocator.getTaskEndpoint();
        @NotNull final Session session = serviceLocator.getSession();
        try {
            serviceLocator.getSessionEndpoint().validateSession(session);
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("**Task Read Command***");

        final Collection<Task> list;
        try {
            list = taskEndpoint.getAllTaskByUserId(session, session.getUserId());
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        for (final Task task : list)
            System.out.println("TASK ID: " + task.getUserId() + " TASK NAME: " + task.getName() +
                    " TASK DESC: " + task.getDescription() + " USER ID" + task.getUserId());
    }

}
