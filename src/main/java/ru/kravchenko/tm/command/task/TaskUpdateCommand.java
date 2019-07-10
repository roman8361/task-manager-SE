package ru.kravchenko.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.TaskServiceBean;
import ru.kravchenko.tm.service.UserServiceBean;
import ru.kravchenko.tm.utils.TerminalService;

/**
 * @author Roman Kravchenko
 */
public class TaskUpdateCommand extends AbstractCommand {

    private TerminalService terminalService = new TerminalService();

    @NotNull
    private UserServiceBean userServiceBean;

    @NotNull
    private TaskServiceBean taskServiceBean;

    public TaskUpdateCommand(@NotNull UserServiceBean userServiceBean,
                             @NotNull TaskServiceBean taskServiceBean) {
        this.userServiceBean = userServiceBean;
        this.taskServiceBean = taskServiceBean;
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