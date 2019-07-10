package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.Project;
import ru.kravchenko.tm.endpoint.ProjectEndpoint;
import ru.kravchenko.tm.endpoint.Session;

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
        @NotNull final Session session = serviceLocator.getSession();
        try {
            serviceLocator.getSessionEndpoint().validateSession(session);
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("**Project Search Command***");
        System.out.println("PLEASE ENTER ID PROJECT: ");
        final String userInput = serviceLocator.getTerminalService().nextLine();

        try {
            final Project project = projectEndpoint.findOneProject(session, userInput);
            System.out.println("PROJECT ID: " + project.getId() + " PROJECT DESCRIPTION: " + project.getDescription());

        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
    }

}
