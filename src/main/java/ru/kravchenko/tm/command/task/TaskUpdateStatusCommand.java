package ru.kravchenko.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.ITaskService;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.entity.StatusProjectTask;

/**
 * @author Roman Kravchenko
 */
public class TaskUpdateStatusCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "task-update-status";
    }

    @Override
    public void getDescription() {
        System.out.println("task-update-status: Update project status by id.");
    }

    @Override
    public void execute(){
        System.out.println("Please enter id task: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String taskId = terminalService.nextLine();
        System.out.println("Please enter number by status (1 - PROCESS, 2 - COMPLETED)");
        @NotNull final String status = terminalService.nextLine();
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();
        if ("1".equals(status)) { taskService.updateTaskStatus(taskId, StatusProjectTask.PROCESS); }
        if ("2".equals(status)) { taskService.updateTaskStatus(taskId, StatusProjectTask.COMPLETED); }
    }

}
