package ru.kravchenko.tm.service;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.reposiroty.IProjectRepository;
import ru.kravchenko.tm.api.reposiroty.ISessionRepository;
import ru.kravchenko.tm.api.reposiroty.ITaskRepository;
import ru.kravchenko.tm.api.reposiroty.IUserRepository;
import ru.kravchenko.tm.api.service.*;
import ru.kravchenko.tm.repository.ProjectRepositoryBean;
import ru.kravchenko.tm.repository.SessionRepositoryBean;
import ru.kravchenko.tm.repository.TaskRepositoryBean;
import ru.kravchenko.tm.repository.UserRepositoryBean;

/**
 * @author Roman Kravchenko
 */

public class LocatorServiceBean implements IServiceLocator {

    @NotNull
    private final ITerminalService terminalService = new TerminalService();

    @NotNull
    private final IConnectionService connectionService = new ConnectionService();

    @NotNull
    private final ITaskRepository taskRepositoryBean = new TaskRepositoryBean(this);

    @NotNull
    private final IUserRepository userRepositoryBean = new UserRepositoryBean(this);

    @NotNull
    private final ISessionRepository sessionRepository = new SessionRepositoryBean(this);

    @NotNull
    private final IProjectRepository projectRepository = new ProjectRepositoryBean(this);

    @NotNull
    private final ISessionService sessionService = new SessionServiceBean(this);

    @NotNull
    private final IUserService userServiceBean = new UserServiceBean(this);

    @NotNull
    private final ITaskService taskService = new TaskServiceBean(this);

    @NotNull
    private final IProjectService projectService = new ProjectServiceBean(this);

    public LocatorServiceBean() throws Exception { }

    @NotNull
    @Override
    public IConnectionService getConnectionService() {
        return connectionService;
    }

    @NotNull
    @Override
    public IProjectService getProjectService() {
        return projectService;
    }

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
    public IUserRepository getUserRepository() {
        return userRepositoryBean;
    }

    @NotNull
    @Override
    public ITaskRepository getTaskRepository() {
        return taskRepositoryBean;
    }

    @NotNull
    @Override
    public IProjectRepository getProjectRepository() {
        return projectRepository;
    }

    @Override
    public ISessionRepository getSessionRepository() {
        return sessionRepository;
    }

    @Override
    public ISessionService getSessionService() {
        return sessionService;
    }

    @NotNull
    @Override
    public ITerminalService getTerminalService() {
        return terminalService;
    }

    @Override
    public IAbout getAbout() {
        return null;
    }

}
