package ru.kravchenko.tm.command.task;

import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.Session;
import ru.kravchenko.tm.endpoint.TaskEndpoint;

/**
 * @author Roman Kravchenko
 */
public class TaskClearCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "task-clear";
    }

    @Override
    public void getDescription() {
        System.out.println("task-clear: Remove all tasks.");
    }

    @Override
    public void execute() {
        TaskEndpoint taskEndpoint = serviceLocator.getTaskEndpoint();
        final Session session = serviceLocator.getSession();
        try {
            serviceLocator.getSessionEndpoint().validateSession(session);
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("**Task Clear Command***");
        try {
            taskEndpoint.removeAllTask(session);
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
        }
        System.out.println("ALL TASK REMOVE");
    }

}
