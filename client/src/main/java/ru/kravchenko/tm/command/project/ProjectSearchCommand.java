package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.ProjectDTO;
import ru.kravchenko.tm.endpoint.ProjectEndpoint;
import ru.kravchenko.tm.endpoint.SessionDTO;

/**
 * @author Roman Kravchenko
 */

public class ProjectSearchCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "project-search";
    }

    @Override
    public void getDescription() {
        System.out.println("project-search: Search project by name or description.");
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
        System.out.println("**Project Search Command***");
        System.out.println("PLEASE ENTER ID PROJECT: ");
        final String userInput = serviceLocator.getTerminalService().nextLine();

        try {
            final ProjectDTO project = projectEndpoint.findOneProject(sessionDTO, userInput);
            System.out.println("PROJECT ID: " + project.getId() + " PROJECT DESCRIPTION: " + project.getDescription());

        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
    }

}
