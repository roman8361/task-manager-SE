package ru.kravchenko.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.SessionDTO;
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
        @NotNull final TaskEndpoint taskEndpoint = serviceLocator.getTaskEndpoint();
        @NotNull final SessionDTO sessionDTO = serviceLocator.getCurrentSession();
        try {
            serviceLocator.getSessionEndpoint().validateSession(sessionDTO);
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("**Task Clear Command***");
        try {
            taskEndpoint.removeAllTaskByUserId(sessionDTO);
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
        }
        System.out.println("ALL TASK REMOVE");
    }

}
