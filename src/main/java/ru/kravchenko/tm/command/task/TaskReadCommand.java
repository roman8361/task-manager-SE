package ru.kravchenko.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.reposiroty.ITaskRepository;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;
import ru.kravchenko.tm.repository.TaskRepositoryBean;
import ru.kravchenko.tm.service.UserServiceBean;
import ru.kravchenko.tm.service.TerminalService;

/**
 * @author Roman Kravchenko
 */

public class TaskReadCommand extends AbstractCommand {

    @NotNull
    private final IServiceLocator serviceLocator;

    @NotNull
    private  final ITerminalService terminalService;

    @NotNull
    private final ITaskRepository taskRepositoryBean;

    @NotNull
    private final IUserService userServiceBean;


    public TaskReadCommand(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        this.terminalService = serviceLocator.getTerminalService();
        this.userServiceBean = serviceLocator.getUserService();
        this.taskRepositoryBean = serviceLocator.getTaskRepository();
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
        taskRepositoryBean.showAllTask();
    }

}
