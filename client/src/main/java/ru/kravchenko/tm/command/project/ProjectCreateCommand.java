package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.ProjectEndpoint;
import ru.kravchenko.tm.endpoint.SessionDTO;

/**
 * @author Roman Kravchenko
 */

public class ProjectCreateCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "project-create";
    }

    @Override
    public void getDescription() {
        System.out.println("project-create: Create new project.");
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
        try {
            projectEndpoint.createProject(sessionDTO, "22222", "dfsdasdad");
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("PROJECT CREATE");
    }

}
