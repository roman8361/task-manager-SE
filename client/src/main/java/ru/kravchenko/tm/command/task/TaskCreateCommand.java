package ru.kravchenko.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.Session;
import ru.kravchenko.tm.endpoint.TaskEndpoint;

/**
 * @author Roman Kravchenko
 */

public class TaskCreateCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "task-create";
    }

    @Override
    public void getDescription() {
        System.out.println("Command: task-create");
    }

    @Override
    public void execute() {
        @NotNull final TaskEndpoint taskEndpoint = serviceLocator.getTaskEndpoint();
        @NotNull final Session session = serviceLocator.getSession();
        System.out.println("SESSIO ID: " + session.getId());
        try {
            serviceLocator.getSessionEndpoint().validateSession(session);
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("**Task Create Command***");
        System.out.println("PLEASE ENTER ID PROJECT: ");
        String projectId = serviceLocator.getTerminalService().nextLine();
        try {
            taskEndpoint.createTask(session, projectId, "task name", "task descrip");
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("TASK CREATE");
    }

}
