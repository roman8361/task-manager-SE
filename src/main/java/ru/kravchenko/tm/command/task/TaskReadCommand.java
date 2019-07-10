package ru.kravchenko.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.reposiroty.ITaskRepository;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;

/**
 * @author Roman Kravchenko
 */

public class TaskReadCommand extends AbstractCommand {

    @Override
    public String getName() { return "task-list"; }

    @Override
    public void getDescription() { System.out.println("Command: task-list"); }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        final @NotNull ITerminalService terminalService = serviceLocator.getTerminalService();
        final @NotNull String userLogin = terminalService.nextLine();
        final @NotNull IUserService userServiceBean = serviceLocator.getUserService();
        if (userServiceBean.existsLoginBase(userLogin)){
            showAllTask();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void showAllTask() {
        final @NotNull ITaskRepository taskRepositoryBean = serviceLocator.getTaskRepository();
        taskRepositoryBean.showAllTask();
    }

}
