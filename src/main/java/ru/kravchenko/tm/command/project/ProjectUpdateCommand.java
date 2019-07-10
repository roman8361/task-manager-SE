package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IProjectService;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;

/**
 * @author Roman Kravchenko
 */

public class ProjectUpdateCommand extends AbstractCommand {

    @NotNull
    private final IServiceLocator serviceLocator;

    @NotNull
    private final ITerminalService terminalService;

    @NotNull
    private final IUserService userServiceBean;

    @NotNull
    private final IProjectService projectServiceBean;

    public ProjectUpdateCommand(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        this.terminalService = serviceLocator.getTerminalService();
        this.userServiceBean = serviceLocator.getUserService();
        this.projectServiceBean = serviceLocator.getProjectService();
    }

    @Override
    public String getName() { return "project-update"; }

    @Override
    public void getDescription() {
        System.out.println("project-update: Update project by id.");
    }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        final String userLogin = terminalService.nextLine();
        if (userServiceBean.existsLoginBase(userLogin)){
            update();
            System.out.println("You remove all project");
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void update() {
        System.out.println("Please enter id project: ");
        final String projectId = terminalService.nextLine();
        System.out.println("Please enter project name: ");
        final String newProjectName = terminalService.nextLine();
        System.out.println("Please enter description for project: ");
        final String newDescription = terminalService.nextLine();
        projectServiceBean.updateProject(projectId, newProjectName, newDescription);
    }

}
