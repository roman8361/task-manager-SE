package ru.kravchenko.tm.command.additional;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.ProjectServiceBean;

/**
 * @author Roman Kravchenko
 */

public class ReferenceCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public void getDescription() {
        System.out.println("help: Show all command.");
    }

    @Override
    public void execute() {
        final @NotNull ProjectServiceBean projectRepositoryBean = (ProjectServiceBean) serviceLocator.getProjectService();
        projectRepositoryBean.showAllCommand();
    }

}