package ru.kravchenko.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.reposiroty.ITaskRepository;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;

/**
 * @author Roman Kravchenko
 */
public class TaskClearCommand extends AbstractCommand {

    @NotNull
    private final IServiceLocator serviceLocator;

    @NotNull
    private final ITerminalService terminalService;

    @NotNull
    private final IUserService userServiceBean;

    @NotNull
    private final ITaskRepository taskRepositoryBean;

    public TaskClearCommand(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        this.terminalService = serviceLocator.getTerminalService();
        this.userServiceBean = serviceLocator.getUserService();
        this.taskRepositoryBean = serviceLocator.getTaskRepository();
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
        taskRepositoryBean.removeAllTask();
    }

}
