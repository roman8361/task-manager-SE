package ru.kravchenko.tm.command.project;

import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.ProjectEndpoint;
import ru.kravchenko.tm.endpoint.SessionDTO;

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
        final SessionDTO sessionDTO = serviceLocator.getCurrentSession();
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

        System.out.println("**Project Remove Command***");
        System.out.println("PLEASE ENTER ID PROJECT: ");
        String idProject = serviceLocator.getTerminalService().nextLine();

        try {
            projectEndpoint.editProject(sessionDTO, idProject, "new name", "new descr");
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("PROJECT EDIT");
    }

}
