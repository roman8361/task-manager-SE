package ru.kravchenko.tm.command.project;

import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.ProjectDTO;
import ru.kravchenko.tm.endpoint.ProjectEndpoint;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

public class ProjectReadCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "project-list";
    }

    @Override
    public void getDescription() {
        System.out.println("project-list: Show all project.");
    }

    @Override
    public void execute() {
        if (serviceLocator.getCurrentSession() == null) {
            System.out.println("PLEASE AUTORISATION");
            return;
        }

        try {
            serviceLocator.getSessionEndpoint().validateSession(serviceLocator.getCurrentSession());
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("***Project Read Command***");
        ProjectEndpoint projectEndpoint = serviceLocator.getProjectEndpoint();
        try {
            List<ProjectDTO> list = projectEndpoint.showAllProject(serviceLocator.getCurrentSession());
            for (final ProjectDTO projectDTO : list) System.out.println(projectDTO.getDescription());
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
    }

}

