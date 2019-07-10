package ru.kravchenko.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.ITaskService;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;
import ru.kravchenko.tm.exception.ProjectNotFoundException;
import ru.kravchenko.tm.repository.ProjectRepositoryBean;

/**
 * @author Roman Kravchenko
 */

public class TaskCreateCommand extends AbstractCommand {

    @Override
    public String getName() { return "task-create"; }

    @Override
    public void getDescription() {
        System.out.println("Command: task-create");
    }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String userLogin = terminalService.nextLine();
        @NotNull final IUserService userServiceBean = serviceLocator.getUserService();
        if (userServiceBean.existsLoginBase(userLogin)){
            createTask();
            System.out.println("Task is add to project");
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void createTask() {
        System.out.println("Please enter id name Project for Task: ");
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
        System.out.println("Please enter task name: ");
        @NotNull final String nameTask = terminalService.nextLine();
        System.out.println("Please enter description for task: ");
        @NotNull final String descriptionTask = terminalService.nextLine();
        @NotNull final ITaskService taskServiceBean = serviceLocator.getTaskService();
        taskServiceBean.mergeTask(projectId, nameTask, descriptionTask);
    }

}
