package ru.kravchenko.tm.command;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.ProjectServiceBean;

/**
 * @author Roman Kravchenko
 */

public class ProjectClearCommand extends AbstractCommand {

    @NotNull
    private ProjectServiceBean projectServiceBean;

    public ProjectClearCommand(@NotNull ProjectServiceBean projectServiceBean) {
        this.projectServiceBean = projectServiceBean;
    }

    @Override
    public String getName() { return "project-clear"; }

    @Override
    public void getDescription() { System.out.println("project-clear: Remove all project."); }

    @Override
    public void execute() { projectServiceBean.removeAllProject(); }

}
