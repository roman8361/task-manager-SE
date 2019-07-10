package ru.kravchenko.tm.command;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.TaskServiceBean;

/**
 * @author Roman Kravchenko
 */
public class TaskReadCommand extends AbstractCommand {

    @NotNull
    private TaskServiceBean taskServiceBean;

    public TaskReadCommand(@NotNull TaskServiceBean taskServiceBean) {
        this.taskServiceBean = taskServiceBean;
    }

    @Override
    public String getName() { return super.getName(); }

    @Override
    public void getDescription() {
        super.getDescription();
    }

    @Override
    public void execute() {
        taskServiceBean.showAllTask();
    }

}
