package ru.kravchenko.tm.command;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.TaskServiceBean;

/**
 * @author Roman Kravchenko
 */
public class TaskUpdateCommand extends AbstractCommand {

    @NotNull
    private TaskServiceBean taskServiceBean;

    public TaskUpdateCommand(@NotNull TaskServiceBean taskServiceBean) {
        this.taskServiceBean = taskServiceBean;
    }

    @Override
    public String getName() { return "task-update"; }

    @Override
    public void getDescription() {
        System.out.println("task-update: Update task by id.");
    }

    @Override
    public void execute() { taskServiceBean.updateTask(); }

}
