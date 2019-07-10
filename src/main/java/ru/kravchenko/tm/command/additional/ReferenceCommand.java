package ru.kravchenko.tm.command.additional;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.reposiroty.IProjectRepository;
import ru.kravchenko.tm.api.service.IProjectService;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.repository.ProjectRepositoryBean;
import ru.kravchenko.tm.service.ProjectServiceBean;

/**
 * @author Roman Kravchenko
 */

public class ReferenceCommand extends AbstractCommand {

    @NotNull
    private final IServiceLocator serviceLocator;

    public ReferenceCommand(final @NotNull IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

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
        final ProjectServiceBean projectRepositoryBean = (ProjectServiceBean) serviceLocator.getProjectService();
        projectRepositoryBean.showAllCommand();
    }

}