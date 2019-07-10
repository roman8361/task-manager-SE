package ru.kravchenko.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ITaskService;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;

/**
 * @author Roman Kravchenko
 */
public class TaskUpdateCommand extends AbstractCommand {

    @NotNull
    private final IServiceLocator serviceLocator;

    @NotNull
    private final ITerminalService terminalService;

    @NotNull
    private final IUserService userServiceBean;

    @NotNull
    private final ITaskService taskServiceBean;

    public TaskUpdateCommand(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        this.terminalService = serviceLocator.getTerminalService();
        this.userServiceBean = serviceLocator.getUserService();
        this.taskServiceBean = serviceLocator.getTaskService();
    }

    @Override
    public String getName() { return "task-update"; }

    @Override
    public void getDescription() {
        System.out.println("task-update: Update task by id.");
    }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        final String userLogin = terminalService.nextLine();
        if (userServiceBean.existsLoginBase(userLogin)) {
            updateTask();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void updateTask() {
        final String taskId = taskServiceBean.getIdFromUser();
        System.out.println("Please enter new task name: ");
        final String taskName = terminalService.nextLine();
        System.out.println("Please enter new description for task: ");
        final String taskDescription = terminalService.nextLine();
        taskServiceBean.updateTask(taskId, taskName, taskDescription);
    }

}