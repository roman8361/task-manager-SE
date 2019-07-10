package ru.kravchenko.tm.command;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.TaskServiceBean;

/**
 * @author Roman Kravchenko
 */
public class TaskCreateCommand extends AbstractCommand {

    @NotNull
    private TaskServiceBean taskServiceBean;

    public TaskCreateCommand(@NotNull TaskServiceBean taskServiceBean) {
        this.taskServiceBean = taskServiceBean;
    }

    @Override
    public String getName() { return super.getName(); }

    @Override
    public void getDescription() {
        super.getDescription();
    }

    @Override
    public void execute() { taskServiceBean.mergeTask(); }

}
