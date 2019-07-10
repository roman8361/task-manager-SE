package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;
import ru.kravchenko.tm.service.ProjectServiceBean;

/**
 * @author Roman Kravchenko
 */

public class ProjectAddToUser extends AbstractCommand {

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
        final  @NotNull ITerminalService terminalService = serviceLocator.getTerminalService();
        System.out.println("Please enter your login: ");
        final @NotNull String userLogin = terminalService.nextLine();
        final @NotNull IUserService userServiceBean  = serviceLocator.getUserService();
        if (userServiceBean.existsLoginBase(userLogin)){
            addProjectToIdUser();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void addProjectToIdUser() {
        final  @NotNull ITerminalService terminalService = serviceLocator.getTerminalService();
        System.out.println("Please enter user login: ");
        final @NotNull String userId = terminalService.nextLine();
        System.out.println("Please enter id project: ");
        final @NotNull String projectId = terminalService.nextLine();
        final@NotNull ProjectServiceBean projectServiceBean = (ProjectServiceBean) serviceLocator.getProjectService();
        projectServiceBean.addProjectToUser(userId, projectId);
    }

}
