package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.ProjectEndpoint;
import ru.kravchenko.tm.endpoint.SessionDTO;

/**
 * @author Roman Kravchenko
 */

public class ProjectClearCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "project-clear";
    }

    @Override
    public void getDescription() {
        System.out.println("project-clear: Remove all project.");
    }

    @Override
    public void execute() {
        @NotNull final ProjectEndpoint projectEndpoint = serviceLocator.getProjectEndpoint();
        @NotNull final SessionDTO sessionDTO = serviceLocator.getCurrentSession();
        if (sessionDTO == null) {
            System.out.println("PLEASE AUTORISATION");
            return;
        }
        try {
            serviceLocator.getSessionEndpoint().validateSession(sessionDTO);
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("***ProjectClearCommand***");
        try {
            projectEndpoint.removeAllProject(sessionDTO);
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("ALL PROJECT REMOVE");
    }

}
