package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.ProjectEndpoint;
import ru.kravchenko.tm.endpoint.Session;
import ru.kravchenko.tm.endpoint.UserNotFoundException_Exception;

/**
 * @author Roman Kravchenko
 */

public class ProjectCreateCommand extends AbstractCommand {

    @Override
    public String getName() { return "project-create"; }

    @Override
    public void getDescription() { System.out.println("project-create: Create new project."); }

    @Override
    public void execute() throws AccessForbiddenException_Exception {
        @NotNull final ProjectEndpoint projectEndpoint = serviceLocator.getProjectEndpoint();
        @NotNull final Session session = serviceLocator.getSession();
        try {
            serviceLocator.getSessionEndpoint().validateSession(session);
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("***Project Create Command***");
        try {
            projectEndpoint.createProject(session, "3333", "wwww");
        } catch (UserNotFoundException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("signature: " + session.getSignature() + " userId: " + session.getUserId() +
                " session Id: " + session.getId());
        System.out.println("PROJECT CREATE");
    }

}
