package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.ProjectServiceBean;
import ru.kravchenko.tm.service.UserServiceBean;
import ru.kravchenko.tm.utils.TerminalService;

/**
 * @author Roman Kravchenko
 */

public class ProjectReadCommand extends AbstractCommand {

    private TerminalService terminalService = new TerminalService();

    @NotNull
    private UserServiceBean userServiceBean;

    @NotNull
    private ProjectServiceBean projectServiceBean;

    public ProjectReadCommand(@NotNull UserServiceBean userServiceBean,
                              @NotNull ProjectServiceBean projectServiceBean) {
        this.userServiceBean = userServiceBean;
        this.projectServiceBean = projectServiceBean;
    }

    @Override
    public String getName() { return "project-list"; }

    @Override
    public void getDescription() { System.out.println("project-list: Show all project."); }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        final String userLogin = terminalService.nextLine();
        if (userServiceBean.existsLoginBase(userLogin)){
            showAllProject();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void showAllProject() { projectServiceBean.showAllProject(); }

}
