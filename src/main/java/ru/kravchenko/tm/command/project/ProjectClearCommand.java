package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.reposiroty.IProjectRepository;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;
import ru.kravchenko.tm.repository.ProjectRepositoryBean;
import ru.kravchenko.tm.service.TerminalService;
import ru.kravchenko.tm.service.UserServiceBean;

/**
 * @author Roman Kravchenko
 */

public class ProjectClearCommand extends AbstractCommand {

    @NotNull
    private final IServiceLocator serviceLocator;

    @NotNull
    private final ITerminalService terminalService;

    @NotNull
    private final IUserService userServiceBean;

    @NotNull
    private final IProjectRepository projectRepository;

    public ProjectClearCommand(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        this.terminalService = serviceLocator.getTerminalService();
        this.projectRepository = serviceLocator.getProjectRepository();
        this.userServiceBean = serviceLocator.getUserService();
    }

    @Override
    public String getName() { return "project-clear"; }

    @Override
    public void getDescription() { System.out.println("project-clear: Remove all project."); }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        final String userLogin = terminalService.nextLine();
        if (userServiceBean.existsLoginBase(userLogin)){
            removeAllProject();
            System.out.println("You remove all project");
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void removeAllProject(){ projectRepository.removeAllProject(); }

}
