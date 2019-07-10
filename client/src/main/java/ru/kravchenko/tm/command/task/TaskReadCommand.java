package ru.kravchenko.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.SessionDTO;
import ru.kravchenko.tm.endpoint.TaskDTO;
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
    public void execute() {
        @NotNull final TaskEndpoint taskEndpoint = serviceLocator.getTaskEndpoint();
        @NotNull final SessionDTO sessionDTO = serviceLocator.getCurrentSession();
        try {
            serviceLocator.getSessionEndpoint().validateSession(sessionDTO);
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("**Task Read Command***");

        final Collection<TaskDTO> list;
        try {
            list = taskEndpoint.getAllTaskByUserId(sessionDTO);
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        for (final TaskDTO task : list)
            System.out.println("TASK ID: " + task.getId() + " TASK NAME: " + task.getName() +
                    " TASK DESC: " + task.getDescription() + " USER ID" + task.getUserId());
    }

}
