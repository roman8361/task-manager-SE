package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;
import ru.kravchenko.tm.service.ProjectServiceBean;

/**
 * @author Roman Kravchenko
 */

public class ProjectAddToUser extends AbstractCommand {

    @NotNull
    private final IServiceLocator serviceLocator;

    @NotNull
    private final ITerminalService terminalService;

    @NotNull
    private final IUserService userServiceBean;

    public ProjectAddToUser(final @NotNull IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        this.terminalService = serviceLocator.getTerminalService();
        this.userServiceBean = serviceLocator.getUserService();
    }

    @Override
    public String getName() {
        return "project-add-user";
    }

    @Override
    public void getDescription() {
        System.out.println("project-add-user: Add project to user id.");
    }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        final String userLogin = terminalService.nextLine();
        if (userServiceBean.existsLoginBase(userLogin)){
            addProjectToIdUser();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void addProjectToIdUser() {
        System.out.println("Please enter user login: ");
        final String userId = terminalService.nextLine();
        System.out.println("Please enter id project: ");
        final String projectId = terminalService.nextLine();
        ProjectServiceBean projectServiceBean = (ProjectServiceBean) serviceLocator.getProjectService();
        projectServiceBean.addProjectToUser(userId, projectId);
    }

}
