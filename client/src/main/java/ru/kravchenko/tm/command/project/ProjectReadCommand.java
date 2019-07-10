package ru.kravchenko.tm.command.project;

import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.Project;
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
    public void execute(){

        try {
            serviceLocator.getSessionEndpoint().validateSession(serviceLocator.getSession());
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("***Project Read Command***");
        ProjectEndpoint projectEndpoint = serviceLocator.getProjectEndpoint();
        try {
            List<Project> list = projectEndpoint.showAllProject(serviceLocator.getSession());
            for (final Project project : list) System.out.println(project.getDescription());
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
    }

}

