package ru.kravchenko.tm.service;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.repository.IProjectRepository;
import ru.kravchenko.tm.api.repository.ISessionRepository;
import ru.kravchenko.tm.api.repository.ITaskRepository;
import ru.kravchenko.tm.api.repository.IUserRepository;
import ru.kravchenko.tm.api.service.*;
import ru.kravchenko.tm.repository.ProjectRepository;
import ru.kravchenko.tm.repository.SessionRepository;
import ru.kravchenko.tm.repository.TaskRepository;
import ru.kravchenko.tm.repository.UserRepository;

/**
 * @author Roman Kravchenko
 */

public class LocatorServiceBean implements IServiceLocator {

    @NotNull
    private final ITerminalService terminalService = new TerminalService();

    @NotNull
    private final IEntityManager entityManager = new EntiryManager();

    @NotNull
    private final IUserRepository userRepository = new UserRepository(this);

    @NotNull
    private final IUserService userService = new UserService(this);

    @NotNull
    private final ISessionRepository sessionRepository = new SessionRepository(this);

    @NotNull
    private final ISessionService sessionService = new SessionService(this);

    @NotNull
    private final IProjectRepository projectRepository = new ProjectRepository(this);

    @NotNull
    private final IProjectService projectService = new ProjectService(this);

    @NotNull
    private final ITaskRepository taskRepository = new TaskRepository(this);

    @NotNull
    private final ITaskService taskService = new TaskService(this);

    public LocatorServiceBean() {
    }

    @NotNull
    @Override
    public ITaskService getTaskService() {
        return taskService;
    }

    @NotNull
    @Override
    public IUserService getUserService() {
        return userService;
    }

    @Override
    public ISessionService getSessionService() {
        return sessionService;
    }

    @Override
    public IProjectService getProjectService() {
        return projectService;
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

    @Override
    public IEntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public IUserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public ISessionRepository getSessionRepository() {
        return sessionRepository;
    }

    @Override
    public IProjectRepository getProjectRepository() {
        return projectRepository;
    }

    @Override
    public ITaskRepository getTaskRepository() {
        return taskRepository;
    }

}
