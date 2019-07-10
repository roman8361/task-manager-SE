package ru.kravchenko.tm.service;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.reposiroty.IProjectRepository;
import ru.kravchenko.tm.api.reposiroty.ITaskRepository;
import ru.kravchenko.tm.api.reposiroty.IUserRepository;
import ru.kravchenko.tm.api.service.*;
import ru.kravchenko.tm.repository.ProjectRepositoryBean;
import ru.kravchenko.tm.repository.TaskRepositoryBean;
import ru.kravchenko.tm.repository.UserRepositoryBean;

/**
 * @author Roman Kravchenko
 */

public class ServiceLocatorBean implements IServiceLocator {

    @NotNull
    private final ITerminalService terminalService = new TerminalService();

    @NotNull
    private final IProjectRepository projectRepository = new ProjectRepositoryBean();

    @NotNull
    private final ITaskRepository taskRepositoryBean  =  new TaskRepositoryBean();

    @NotNull
    private final IUserRepository userRepositoryBean = new UserRepositoryBean();

    @NotNull
    private final IUserService userServiceBean = new UserServiceBean(this);

    @NotNull
    private final ITaskService taskService = new TaskServiceBean(this);

    @NotNull
    private final IProjectService projectService = new ProjectServiceBean(this);

    @NotNull
    @Override
    public IProjectService getProjectService() { return projectService; }

    @NotNull
    @Override
    public ITaskService getTaskService() {
        return taskService;
    }

    @NotNull
    @Override
    public IUserService getUserService() {
        return userServiceBean;
    }

    @NotNull
    @Override
    public IUserRepository getUserRepository() { return userRepositoryBean; }

    @NotNull
    @Override
    public ITaskRepository getTaskRepository() { return taskRepositoryBean; }

    @NotNull
    @Override
    public IProjectRepository getProjectRepository() { return projectRepository; }

    @NotNull
    @Override
    public ITerminalService getTerminalService() { return terminalService; }

    @Override
    public IAbout getAbout() {
        return null;
    }

}
