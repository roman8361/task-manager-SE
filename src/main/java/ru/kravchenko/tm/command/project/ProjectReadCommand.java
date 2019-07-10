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
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        System.out.println("Please enter your login: ");
        @NotNull final String userLogin = terminalService.nextLine();
        @NotNull final IUserService userServiceBean = serviceLocator.getUserService();
        if (userServiceBean.existsLoginBase(userLogin)) { // проверка валидации пользователя
            System.out.println("Please enter sort selection (1 - by add; 2 - by date begin; 3 - by date end; 4 - by status)");
            @NotNull final String userSelect = terminalService.nextLine();
            switch (userSelect) {
                case "1":
                    showAllProjectByAdd();
                    break;

                case "2":
                    sortByDateBegin();
                    break;

                case "3":
                    sortByDateEnd();
                    break;

                case "4":
                    sortByDateStatus();
                    break;

                default:
                    System.out.println("Unidentified command, please try again");
            }
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void showAllProjectByAdd() {
        @NotNull final IProjectRepository projectRepository = serviceLocator.getProjectRepository();
        projectRepository.showAllProject();
    }

    private void sortByDateBegin() {
        @NotNull final IProjectRepository projectRepository = serviceLocator.getProjectRepository();
        projectRepository.sortByDateBegin();
    }

    private void sortByDateEnd() {
        @NotNull final IProjectRepository projectRepository = serviceLocator.getProjectRepository();
        projectRepository.sortByDateEnd();
    }

    private void sortByDateStatus() {
        @NotNull final IProjectRepository projectRepository = serviceLocator.getProjectRepository();
        projectRepository.sortByStatus();
    }

}
