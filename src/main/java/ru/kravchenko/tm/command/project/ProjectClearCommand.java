package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.reposiroty.IProjectRepository;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;

/**
 * @author Roman Kravchenko
 */

public class ProjectClearCommand extends AbstractCommand {

    @Override
    public String getName() { return "project-clear"; }

    @Override
    public void getDescription() { System.out.println("project-clear: Remove all project."); }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String userLogin = terminalService.nextLine();
        @NotNull final IUserService userServiceBean = serviceLocator.getUserService();
        if (userServiceBean.existsLoginBase(userLogin)){
            removeAllProject();
            System.out.println("You remove all project");
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void removeAllProject(){
        @NotNull final IProjectRepository projectRepository = serviceLocator.getProjectRepository();
        projectRepository.removeAllProject();
    }

}
