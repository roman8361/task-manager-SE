package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.reposiroty.IProjectRepository;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;

/**
 * @author Roman Kravchenko
 */

public class ProjectReadCommand extends AbstractCommand {

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
        final @NotNull ITerminalService terminalService = serviceLocator.getTerminalService();
        System.out.println("Please enter your login: ");
        final @NotNull String userLogin = terminalService.nextLine();
        final @NotNull IUserService userServiceBean = serviceLocator.getUserService();
        if (userServiceBean.existsLoginBase(userLogin)) {
            showAllProject();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void showAllProject() {
        final @NotNull IProjectRepository projectRepository = serviceLocator.getProjectRepository();
        projectRepository.showAllProject();
    }

}
