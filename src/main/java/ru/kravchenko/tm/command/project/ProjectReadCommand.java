package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.reposiroty.IProjectRepository;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.service.TerminalService;
import ru.kravchenko.tm.service.UserServiceBean;

/**
 * @author Roman Kravchenko
 */

public class ProjectReadCommand extends AbstractCommand {

    @NotNull
    private final IServiceLocator serviceLocator;

    @NotNull
    private final TerminalService terminalService;

    @NotNull
    private final UserServiceBean userServiceBean;

    @NotNull
    private final IProjectRepository projectRepository;

    public ProjectReadCommand(final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        this.terminalService = (TerminalService) serviceLocator.getTerminalService();
        this.userServiceBean = (UserServiceBean) serviceLocator.getUserService();
        this.projectRepository = serviceLocator.getProjectRepository();
    }

    @Override
    public String getName() {
        return "project-list";
    }

    @Override
    public void getDescription() {
        System.out.println("project-list: Show all project.");
    }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        final String userLogin = terminalService.nextLine();
        if (userServiceBean.existsLoginBase(userLogin)) {
            showAllProject();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void showAllProject() {
        projectRepository.showAllProject();
    }

}
