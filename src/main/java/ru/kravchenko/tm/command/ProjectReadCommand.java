package ru.kravchenko.tm.command;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.ProjectServiceBean;

/**
 * @author Roman Kravchenko
 */

public class ProjectReadCommand extends AbstractCommand {

    @NotNull
    private ProjectServiceBean projectServiceBean;

    public ProjectReadCommand(@NotNull ProjectServiceBean projectServiceBean) {
        this.projectServiceBean = projectServiceBean;
    }

    @Override
    public String getName() { return "project-list"; }

    @Override
    public void getDescription() { System.out.println("project-list: Show all project."); }

    @Override
    public void execute() { projectServiceBean.showAllProject(); }

}
