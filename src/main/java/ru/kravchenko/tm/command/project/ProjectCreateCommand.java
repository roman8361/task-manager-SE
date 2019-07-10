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
        final @NotNull ITerminalService terminalService = serviceLocator.getTerminalService();
        final @NotNull String userLogin = terminalService.nextLine();
        final @NotNull IUserService userServiceBean = serviceLocator.getUserService();
        if (userServiceBean.existsLoginBase(userLogin)){
            createProject();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void createProject() {
        final @NotNull ITerminalService terminalService = serviceLocator.getTerminalService();
        System.out.println("Please enter project name: ");
        final @NotNull String nameProject = terminalService.nextLine();
        System.out.println("Please enter description for project: ");
        final @NotNull String descriptionProject = terminalService.nextLine();
        final @NotNull IProjectService projectServiceBean = serviceLocator.getProjectService();
        projectServiceBean.createProject(nameProject, descriptionProject);
    }

}
