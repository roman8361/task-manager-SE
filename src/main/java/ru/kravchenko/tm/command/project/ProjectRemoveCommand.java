package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.reposiroty.IProjectRepository;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;
import ru.kravchenko.tm.exception.ProjectNotFoundException;

/**
 * @author Roman Kravchenko
 */

public class ProjectRemoveCommand extends AbstractCommand {

    @Override
    public String getName() { return "project-remove"; }

    @Override
    public void getDescription() {
        System.out.println("project-remove: Remove selected project by id.");
    }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String userLogin = terminalService.nextLine();
        @NotNull final IUserService userServiceBean = serviceLocator.getUserService();
        if (userServiceBean.existsLoginBase(userLogin)){
            removeById();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void removeById() {
        System.out.println("Please enter id project: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String projectId = terminalService.nextLine();
        @NotNull final IProjectRepository projectRepository = serviceLocator.getProjectRepository();
        if (!projectRepository.existProject(projectId)) {
            try {
                throw new ProjectNotFoundException();
            } catch (@NotNull final ProjectNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }
        projectRepository.removeById(projectId);
    }

}
