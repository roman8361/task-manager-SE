package ru.kravchenko.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ITaskService;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;
import ru.kravchenko.tm.service.TaskServiceBean;
import ru.kravchenko.tm.service.UserServiceBean;
import ru.kravchenko.tm.service.TerminalService;

/**
 * @author Roman Kravchenko
 */

public class TaskCreateCommand extends AbstractCommand {

    @NotNull
    private final IServiceLocator serviceLocator;

    @NotNull
    private final ITerminalService terminalService;

    @NotNull
    private final IUserService userServiceBean;

    @NotNull
    private final ITaskService taskServiceBean;

    public TaskCreateCommand(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        this.terminalService = serviceLocator.getTerminalService();
        this.userServiceBean = serviceLocator.getUserService();
        this.taskServiceBean = serviceLocator.getTaskService();
    }

    @Override
    public String getName() { return "task-create"; }

    @Override
    public void getDescription() {
        System.out.println("Command: task-create");
    }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        final String userLogin = terminalService.nextLine();
        if (userServiceBean.existsLoginBase(userLogin)){
            createTask();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void createTask() {
        System.out.println("Please enter id name Project for Task: ");
        final String projectId = terminalService.nextLine();
        System.out.println("Please enter task name: ");
        final String nameTask = terminalService.nextLine();
        System.out.println("Please enter description for task: ");
        final String descriptionTask = terminalService.nextLine();
        taskServiceBean.mergeTask(projectId, nameTask, descriptionTask);
    }

}
