package ru.kravchenko.tm.command;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.TaskServiceBean;

/**
 * @author Roman Kravchenko
 */
public class TaskClearCommand extends AbstractCommand {

    @NotNull
    private TaskServiceBean taskServiceBean;

    public TaskClearCommand(@NotNull TaskServiceBean taskServiceBean) {
        this.taskServiceBean = taskServiceBean;
    }

    @Override
    public String getName() { return "task-clear"; }

    @Override
    public void getDescription() {
        System.out.println("task-clear: Remove all tasks.");
    }

    @Override
    public void execute() {taskServiceBean.removeAllTask();}

}
