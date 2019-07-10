package ru.kravchenko.tm.command;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.ProjectServiceBean;

/**
 * @author Roman Kravchenko
 */

public class ProjectRemoveCommand extends AbstractCommand {

    @NotNull
    private ProjectServiceBean projectServiceBean;

    public ProjectRemoveCommand(@NotNull ProjectServiceBean projectServiceBean) {
        this.projectServiceBean = projectServiceBean;
    }

    @Override
    public String getName() { return "project-remove"; }

    @Override
    public void getDescription() {
        System.out.println("project-remove: Remove selected project by id.");
    }

    @Override
    public void execute() {
        projectServiceBean.removeById();
    }

}
