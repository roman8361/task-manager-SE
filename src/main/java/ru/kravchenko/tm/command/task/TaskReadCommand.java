package ru.kravchenko.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.TaskServiceBean;
import ru.kravchenko.tm.service.UserServiceBean;
import ru.kravchenko.tm.utils.TerminalService;

/**
 * @author Roman Kravchenko
 */

public class TaskReadCommand extends AbstractCommand {

    private TerminalService terminalService = new TerminalService();

    @NotNull
    private UserServiceBean userServiceBean;

    @NotNull
    private TaskServiceBean taskServiceBean;

    public TaskReadCommand(@NotNull UserServiceBean userServiceBean,
                           @NotNull TaskServiceBean taskServiceBean) {
        this.userServiceBean = userServiceBean;
        this.taskServiceBean = taskServiceBean;
    }

    @Override
    public String getName() { return "task-list"; }

    @Override
    public void getDescription() { System.out.println("Command: task-list"); }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        final String userLogin = terminalService.nextLine();
        if (userServiceBean.existsLoginBase(userLogin)){
            showAllTask();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");

    }

    private void showAllTask() {
        taskServiceBean.showAllTask();
    }

}
