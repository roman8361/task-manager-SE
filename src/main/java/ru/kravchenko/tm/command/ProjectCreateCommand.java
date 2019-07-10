package ru.kravchenko.tm.command;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.ProjectServiceBean;

/**
 * @author Roman Kravchenko
 */

public class ProjectCreateCommand extends AbstractCommand {

    @NotNull
    private ProjectServiceBean projectServiceBean;

    public ProjectCreateCommand(@NotNull ProjectServiceBean projectServiceBean) {
        this.projectServiceBean = projectServiceBean;
    }

    @Override
    public String getName() { return "project-create"; }

    @Override
    public void getDescription() { System.out.println("project-create: Create new project."); }

    @Override
    public void execute() { projectServiceBean.mergeProject(); }

}
