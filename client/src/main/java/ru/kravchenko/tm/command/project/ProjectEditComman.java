package ru.kravchenko.tm.command.project;

import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.ProjectEndpoint;
import ru.kravchenko.tm.endpoint.Session;

/**
 * @author Roman Kravchenko
 */

public class ProjectEditComman extends AbstractCommand {
    @Override
    public String getName() {
        return "project-edit";
    }

    @Override
    public void getDescription() {
        System.out.println("project-edit: Edit selected project by id.");
    }

    @Override
    public void execute() {
        final ProjectEndpoint projectEndpoint = serviceLocator.getProjectEndpoint();
        final Session session = serviceLocator.getSession();
        try {
            serviceLocator.getSessionEndpoint().validateSession(session);
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }

        System.out.println("**Project Remove Command***");
        System.out.println("PLEASE ENTER ID PROJECT: ");
        String idProject = serviceLocator.getTerminalService().nextLine();

        try {
            projectEndpoint.editProject(session, idProject, "new name", "new descr");
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("PROJECT EDIT");
    }

}
