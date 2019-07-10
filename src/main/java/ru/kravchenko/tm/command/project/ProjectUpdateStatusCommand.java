package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IProjectService;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.entity.StatusProjectTask;
import ru.kravchenko.tm.exception.ProjectNotFoundException;
import ru.kravchenko.tm.repository.ProjectRepositoryBean;

/**
 * @author Roman Kravchenko
 */

public class ProjectUpdateStatusCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "project-update-status";
    }

    @Override
    public void getDescription() {
        System.out.println("project-update-status: Update project status by id.");
    }

    @Override
    public void execute(){
        System.out.println("Please enter id project: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String projectId = terminalService.nextLine();
        @NotNull final ProjectRepositoryBean projectRepositoryBean = (ProjectRepositoryBean) serviceLocator.getProjectRepository();
        if (!projectRepositoryBean.existProject(projectId)) {
            try {
                throw new ProjectNotFoundException();
            } catch (@NotNull final ProjectNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }
        System.out.println("Please enter number by status (1 - PROCESS, 2 - COMPLETED)");
        @NotNull final String userSelect = terminalService.nextLine();
        @NotNull final IProjectService projectServiceBean = serviceLocator.getProjectService();
        switch (userSelect) {
            case "1":
                projectServiceBean.updateStatusProject(projectId, StatusProjectTask.PROCESS);
                break;
            case "2":
                projectServiceBean.updateStatusProject(projectId, StatusProjectTask.COMPLETED);
                break;
            default:
                System.out.println("Unidentified command, please try again");
        }
        return;
    }

}
