package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IProjectService;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;
import ru.kravchenko.tm.exception.ProjectNotFoundException;
import ru.kravchenko.tm.repository.ProjectRepositoryBean;

/**
 * @author Roman Kravchenko
 */

public class ProjectUpdateCommand extends AbstractCommand {

    @Override
    public String getName() { return "project-update"; }

    @Override
    public void getDescription() {
        System.out.println("project-update: Update project by id.");
    }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String userLogin = terminalService.nextLine();
        @NotNull final IUserService userServiceBean = serviceLocator.getUserService();
        if (userServiceBean.existsLoginBase(userLogin)){
            update();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void update() {
        System.out.println("Please enter id project: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String projectId = terminalService.nextLine();
        @NotNull final IProjectService projectServiceBean = serviceLocator.getProjectService();
        final @NotNull ProjectRepositoryBean projectRepositoryBean = (ProjectRepositoryBean) serviceLocator.getProjectRepository();
        if (!projectRepositoryBean.existProject(projectId)) {
            try {
                throw new ProjectNotFoundException();
            } catch (ProjectNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }
        System.out.println("Please enter project name: ");
        @NotNull final String newProjectName = terminalService.nextLine();
        System.out.println("Please enter description for project: ");
        @NotNull final String newDescription = terminalService.nextLine();
        projectServiceBean.updateProject(projectId, newProjectName, newDescription);
    }

}
