package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.ProjectServiceBean;
import ru.kravchenko.tm.service.UserServiceBean;
import ru.kravchenko.tm.utils.TerminalService;

/**
 * @author Roman Kravchenko
 */

public class ProjectAddToUser extends AbstractCommand {

    private TerminalService terminalService = new TerminalService();

    @NotNull
    private UserServiceBean userServiceBean;

    @NotNull
    private ProjectServiceBean projectServiceBean;

    public ProjectAddToUser(@NotNull UserServiceBean userServiceBean,
                            @NotNull ProjectServiceBean projectServiceBean) {
        this.userServiceBean = userServiceBean;
        this.projectServiceBean = projectServiceBean;
    }

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
        System.out.println("Please enter your login: ");
        final String userLogin = terminalService.nextLine();
        if (userServiceBean.existsLoginBase(userLogin)){
            addProjectToIdUser();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void addProjectToIdUser() {
        System.out.println("Please enter user login: ");
        String userId = terminalService.nextLine();
        System.out.println("Please enter id project: ");
        String projectId = terminalService.nextLine();
        projectServiceBean.addProjectToUser(userId, projectId);
    }

}
