package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.ProjectServiceBean;
import ru.kravchenko.tm.service.UserServiceBean;
import ru.kravchenko.tm.utils.TerminalService;

/**
 * @author Roman Kravchenko
 */

public class ProjectCreateCommand extends AbstractCommand {

    private TerminalService terminalService = new TerminalService();

    @NotNull
    private UserServiceBean userServiceBean;

    @NotNull
    private ProjectServiceBean projectServiceBean;

    public ProjectCreateCommand(@NotNull UserServiceBean userServiceBean,
                                @NotNull ProjectServiceBean projectServiceBean) {
        this.userServiceBean = userServiceBean;
        this.projectServiceBean = projectServiceBean;
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
        String nameProject = terminalService.nextLine();
        System.out.println("Please enter description for project: ");
        final String descriptionProject = terminalService.nextLine();
        projectServiceBean.createProject(nameProject, descriptionProject);
    }

}
