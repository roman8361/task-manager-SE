package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IProjectService;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;

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
        final @NotNull ITerminalService terminalService = serviceLocator.getTerminalService();
        final @NotNull String userLogin = terminalService.nextLine();
        final @NotNull IUserService userServiceBean = serviceLocator.getUserService();
        if (userServiceBean.existsLoginBase(userLogin)){
            update();
            System.out.println("You remove all project");
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void update() {
        System.out.println("Please enter id project: ");
        final @NotNull ITerminalService terminalService = serviceLocator.getTerminalService();
        final @NotNull String projectId = terminalService.nextLine();
        System.out.println("Please enter project name: ");
        final @NotNull String newProjectName = terminalService.nextLine();
        System.out.println("Please enter description for project: ");
        final @NotNull String newDescription = terminalService.nextLine();
        final @NotNull IProjectService projectServiceBean = serviceLocator.getProjectService();
        projectServiceBean.updateProject(projectId, newProjectName, newDescription);
    }

}
