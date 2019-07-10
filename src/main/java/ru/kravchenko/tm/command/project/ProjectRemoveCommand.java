package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.ProjectServiceBean;
import ru.kravchenko.tm.service.UserServiceBean;
import ru.kravchenko.tm.utils.TerminalService;

/**
 * @author Roman Kravchenko
 */

public class ProjectRemoveCommand extends AbstractCommand {

    private TerminalService terminalService = new TerminalService();

    @NotNull
    private UserServiceBean userServiceBean;

    @NotNull
    private ProjectServiceBean projectServiceBean;

    public ProjectRemoveCommand(@NotNull UserServiceBean userServiceBean,
                                @NotNull ProjectServiceBean projectServiceBean) {
        this.userServiceBean = userServiceBean;
        this.projectServiceBean = projectServiceBean;
    }

    @Override
    public String getName() { return "project-remove"; }

    @Override
    public void getDescription() {
        System.out.println("project-remove: Remove selected project by id.");
    }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        final String userLogin = terminalService.nextLine();
        if (userServiceBean.existsLoginBase(userLogin)){
            removeById();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void removeById() {
        System.out.println("Please enter id project: ");
        String projectId = terminalService.nextLine();
        projectServiceBean.removeById(projectId);
    }

}
