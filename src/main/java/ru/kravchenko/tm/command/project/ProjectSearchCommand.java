package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IProjectService;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;

/**
 * @author Roman Kravchenko
 */

public class ProjectSearchCommand extends AbstractCommand {

    @Override
    public String getName() { return "project-search"; }

    @Override
    public void getDescription() {
        System.out.println("project-search: Search project by name or description.");
    }

    @Override
    public void execute(){
        System.out.println("Please enter your login: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String userLogin = terminalService.nextLine();
        @NotNull final IUserService userServiceBean = serviceLocator.getUserService();
        if (userServiceBean.existsLoginBase(userLogin)){
            System.out.println("Please enter search selection (1 - by name; 2 - by description;)");
            @NotNull final String userSelect = terminalService.nextLine();
            switch (userSelect) {
                case "1":
                    searchByName();
                    break;

                case "2":
                    searchByDescription();
                    break;

                default:
                    System.out.println("Unidentified command, please try again");
            }
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void searchByName() {
        System.out.println("Please enter text: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String userText = terminalService.nextLine();
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        projectService.searchInName(userText);
    }

    private void searchByDescription() {
        System.out.println("Please enter text: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String userText = terminalService.nextLine();
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();
        projectService.searchInDescription(userText);
    }

}
