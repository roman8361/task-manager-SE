package ru.kravchenko.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.ITaskService;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;

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
        final @NotNull ITerminalService terminalService = serviceLocator.getTerminalService();
        final @NotNull String userLogin = terminalService.nextLine();
        final @NotNull IUserService userServiceBean = serviceLocator.getUserService();
        if (userServiceBean.existsLoginBase(userLogin)){
            createTask();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void createTask() {
        System.out.println("Please enter id name Project for Task: ");
        final @NotNull ITerminalService terminalService = serviceLocator.getTerminalService();
        final @NotNull String projectId = terminalService.nextLine();
        System.out.println("Please enter task name: ");
        final @NotNull String nameTask = terminalService.nextLine();
        System.out.println("Please enter description for task: ");
        final @NotNull String descriptionTask = terminalService.nextLine();
        final @NotNull ITaskService taskServiceBean = serviceLocator.getTaskService();
        taskServiceBean.mergeTask(projectId, nameTask, descriptionTask);
    }

}
