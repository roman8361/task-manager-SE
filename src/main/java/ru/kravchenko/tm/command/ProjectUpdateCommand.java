package ru.kravchenko.tm.command;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.ProjectServiceBean;

/**
 * @author Roman Kravchenko
 */
public class ProjectUpdateCommand extends AbstractCommand {

    @NotNull
    private ProjectServiceBean projectServiceBean;

    public ProjectUpdateCommand(@NotNull ProjectServiceBean projectServiceBean) {
        this.projectServiceBean = projectServiceBean;
    }

    @Override
    public String getName() { return "project-update"; }

    @Override
    public void getDescription() {
        System.out.println("project-update: Update project by id.");
    }

    @Override
    public void execute() { projectServiceBean.updateProject(); }

}
