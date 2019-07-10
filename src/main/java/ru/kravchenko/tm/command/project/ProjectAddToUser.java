package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;
import ru.kravchenko.tm.exception.ProjectNotFoundException;
import ru.kravchenko.tm.exception.UserNotFoundException;
import ru.kravchenko.tm.repository.ProjectRepositoryBean;
import ru.kravchenko.tm.repository.UserRepositoryBean;
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
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        System.out.println("Please enter your login: ");
        @NotNull final String userLogin = terminalService.nextLine();
        @NotNull final IUserService userServiceBean  = serviceLocator.getUserService();
        if (userServiceBean.existsLoginBase(userLogin)){
            addProjectToIdUser();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void addProjectToIdUser() {
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        System.out.println("Please enter user login: ");
        @NotNull final String userId = terminalService.nextLine();
        @NotNull final UserRepositoryBean userRepositoryBean = (UserRepositoryBean) serviceLocator.getUserRepository();
        if (!userRepositoryBean.existUser(userId)){
            try {
                throw new UserNotFoundException();
            } catch (UserNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }
        System.out.println("Please enter id project: ");
        @NotNull final String projectId = terminalService.nextLine();
        @NotNull final ProjectRepositoryBean projectRepositoryBean = (ProjectRepositoryBean) serviceLocator.getProjectRepository();
        if (!projectRepositoryBean.existProject(projectId)) {
            try {
                throw new ProjectNotFoundException();
            } catch (@NotNull final ProjectNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }
        @NotNull final ProjectServiceBean projectServiceBean = (ProjectServiceBean) serviceLocator.getProjectService();
        projectServiceBean.addProjectToUser(userId, projectId);
    }

}
