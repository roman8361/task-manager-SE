package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.reposiroty.IProjectRepository;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;

/**
 * @author Roman Kravchenko
 */

public class ProjectRemoveCommand extends AbstractCommand {

    @NotNull
    private final IServiceLocator serviceLocator;

    @NotNull
    private final ITerminalService terminalService;

    @NotNull
    private final IUserService userServiceBean;

    @NotNull
    private final IProjectRepository projectRepository;

    public ProjectRemoveCommand(final @NotNull IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        this.terminalService = serviceLocator.getTerminalService();
        this.userServiceBean = serviceLocator.getUserService();
        this.projectRepository = serviceLocator.getProjectRepository();
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
        final String projectId = terminalService.nextLine();
        projectRepository.removeById(projectId);
    }

}
