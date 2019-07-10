package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IProjectService;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;

/**
 * @author Roman Kravchenko
 */

public class ProjectCreateCommand extends AbstractCommand {

    @Override
    public String getName() { return "project-create"; }

    @Override
    public void getDescription() { System.out.println("project-create: Create new project."); }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String userLogin = terminalService.nextLine();
        @NotNull final IUserService userServiceBean = serviceLocator.getUserService();
        if (userServiceBean.existsLoginBase(userLogin)){
            createProject();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void createProject() {
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        System.out.println("Please enter project name: ");
        @NotNull final String nameProject = terminalService.nextLine();
        System.out.println("Please enter description for project: ");
        @NotNull final String descriptionProject = terminalService.nextLine();
        @NotNull final IProjectService projectServiceBean = serviceLocator.getProjectService();
        projectServiceBean.createProject(nameProject, descriptionProject);
    }

}
