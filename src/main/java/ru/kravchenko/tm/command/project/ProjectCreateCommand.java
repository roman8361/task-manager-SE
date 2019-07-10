package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IProjectService;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;
import ru.kravchenko.tm.service.ProjectServiceBean;
import ru.kravchenko.tm.service.TerminalService;
import ru.kravchenko.tm.service.UserServiceBean;

/**
 * @author Roman Kravchenko
 */

public class ProjectCreateCommand extends AbstractCommand {

    @NotNull
    private final IServiceLocator serviceLocator;

    @NotNull
    private final ITerminalService terminalService;

    @NotNull
    private final IUserService userServiceBean;

    @NotNull
    private final IProjectService projectServiceBean;

    public ProjectCreateCommand(final @NotNull IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        this.terminalService = serviceLocator.getTerminalService();
        this.userServiceBean = serviceLocator.getUserService();
        this.projectServiceBean = serviceLocator.getProjectService();
    }

    @Override
    public String getName() { return "project-create"; }

    @Override
    public void getDescription() { System.out.println("project-create: Create new project."); }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        final String userLogin = terminalService.nextLine();
        if (userServiceBean.existsLoginBase(userLogin)){
            createProject();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void createProject() {
        System.out.println("Please enter project name: ");
        final String nameProject = terminalService.nextLine();
        System.out.println("Please enter description for project: ");
        final String descriptionProject = terminalService.nextLine();
        projectServiceBean.createProject(nameProject, descriptionProject);
    }

}
