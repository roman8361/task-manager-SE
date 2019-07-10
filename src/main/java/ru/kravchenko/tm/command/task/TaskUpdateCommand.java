package ru.kravchenko.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.ITaskService;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;
import ru.kravchenko.tm.exception.TaskNotFoundException;
import ru.kravchenko.tm.repository.TaskRepositoryBean;

/**
 * @author Roman Kravchenko
 */
public class TaskUpdateCommand extends AbstractCommand {

    @Override
    public String getName() { return "task-update"; }

    @Override
    public void getDescription() {
        System.out.println("task-update: Update task by id.");
    }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String userLogin = terminalService.nextLine();
        @NotNull final IUserService userServiceBean = serviceLocator.getUserService();
        if (userServiceBean.existsLoginBase(userLogin)) {
            updateTask();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void updateTask() {
        final @NotNull ITaskService taskServiceBean = serviceLocator.getTaskService();
        System.out.println("Please enter id task: ");
        final String taskId = taskServiceBean.getIdFromUser();
        @NotNull final TaskRepositoryBean taskRepositoryBean = (TaskRepositoryBean) serviceLocator.getTaskRepository();
        if (!taskRepositoryBean.existTask(taskId)) {
            try {
                throw new TaskNotFoundException();
            } catch (@NotNull final TaskNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }
        final @NotNull ITerminalService terminalService = serviceLocator.getTerminalService();
        System.out.println("Please enter new task name: ");
        final String taskName = terminalService.nextLine();
        System.out.println("Please enter new description for task: ");
        final String taskDescription = terminalService.nextLine();
        taskServiceBean.updateTask(taskId, taskName, taskDescription);
    }

}