package ru.kravchenko.tm.service;

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

    private final ITerminalService terminalService = new TerminalService();

    private final IProjectRepository projectRepository = new ProjectRepositoryBean();

    private final ITaskRepository taskRepositoryBean  =  new TaskRepositoryBean();

    private final IUserRepository userRepositoryBean = new UserRepositoryBean();

    private final IUserService userServiceBean = new UserServiceBean(this);

    private final ITaskService taskService = new TaskServiceBean(this);

    private final IProjectService projectService = new ProjectServiceBean(this);

    public IProjectService getProjectService() { return projectService; }

    @Override
    public ITaskService getTaskService() {
        return taskService;
    }

    @Override
    public IUserService getUserService() {
        return userServiceBean;
    }

    public IUserRepository getUserRepository() { return userRepositoryBean; }

    public ITaskRepository getTaskRepository() { return taskRepositoryBean; }

    @Override
    public IProjectRepository getProjectRepository() { return projectRepository; }

    @Override
    public ITerminalService getTerminalService() { return terminalService; }

    @Override
    public IAbout getAbout() {
        return null;
    }

}
