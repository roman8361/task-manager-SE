package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.ITerminalService;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.Project;
import ru.kravchenko.tm.endpoint.ProjectEndpoint;
import ru.kravchenko.tm.endpoint.Session;

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
    public void execute() throws AccessForbiddenException_Exception {
        ProjectEndpoint projectEndpoint = serviceLocator.getProjectEndpoint();
        final Session session = serviceLocator.getSession();
        try {
            serviceLocator.getSessionEndpoint().validateSession(session);
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("***Project Read Command***");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        System.out.println("Please enter sort selection (1 - by add; 2 - by date begin; 3 - by date end; 4 - by status)");
        @NotNull final String userSelect = terminalService.nextLine();

        switch (userSelect) {
            case "1":
                List<Project> list = projectEndpoint.showAllProject(session);
                for (final Project project : list) System.out.println(project.getDescription());
                break;

            case "2":
                List<Project> list2 = projectEndpoint.sortByDateBegin(session);
                for (final Project project : list2) System.out.println(project.getDescription());
                break;

            case "3":
                List<Project> list3 = projectEndpoint.sortByDateEnd(session);
                for (final Project project : list3) System.out.println(project.getDescription());
                break;

            case "4":
                List<Project> list4 = projectEndpoint.sortByStatus(session);
                for (final Project project : list4) System.out.println(project.getDescription());
                break;

            default:
                System.out.println("Unidentified command, please try again");
        }
    }

}

