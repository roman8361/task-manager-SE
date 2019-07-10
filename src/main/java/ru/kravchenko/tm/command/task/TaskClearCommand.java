package ru.kravchenko.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.TaskServiceBean;
import ru.kravchenko.tm.service.UserServiceBean;
import ru.kravchenko.tm.utils.TerminalService;

/**
 * @author Roman Kravchenko
 */
public class TaskClearCommand extends AbstractCommand {

    private TerminalService terminalService = new TerminalService();

    @NotNull
    private UserServiceBean userServiceBean;

    @NotNull
    private TaskServiceBean taskServiceBean;

    public TaskClearCommand(@NotNull UserServiceBean userServiceBean,
                            @NotNull TaskServiceBean taskServiceBean) {
        this.userServiceBean = userServiceBean;
        this.taskServiceBean = taskServiceBean;
    }

    @Override
    public String getName() { return "task-clear"; }

    @Override
    public void getDescription() {
        System.out.println("task-clear: Remove all tasks.");
    }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        final String userLogin = terminalService.nextLine();
        if (userServiceBean.existsLoginBase(userLogin)){
            removeAllTask();
            System.out.println("You remove all task");
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void removeAllTask() {
        taskServiceBean.removeAllTask();
    }

}
