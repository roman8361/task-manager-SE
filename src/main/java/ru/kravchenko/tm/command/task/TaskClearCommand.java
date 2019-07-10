package ru.kravchenko.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.reposiroty.ITaskRepository;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;

/**
 * @author Roman Kravchenko
 */
public class TaskClearCommand extends AbstractCommand {

    @Override
    public String getName() { return "task-clear"; }

    @Override
    public void getDescription() {
        System.out.println("task-clear: Remove all tasks.");
    }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        final @NotNull ITerminalService terminalService = serviceLocator.getTerminalService();
        final @NotNull String userLogin = terminalService.nextLine();
        final @NotNull IUserService userServiceBean = serviceLocator.getUserService();
        if (userServiceBean.existsLoginBase(userLogin)){
            removeAllTask();
            System.out.println("You remove all task");
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void removeAllTask() {
        final @NotNull ITaskRepository taskRepositoryBean = serviceLocator.getTaskRepository();
        taskRepositoryBean.removeAllTask();
    }

}
