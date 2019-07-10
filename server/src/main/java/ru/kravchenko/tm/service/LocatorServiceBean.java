package ru.kravchenko.tm.service;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.service.*;

/**
 * @author Roman Kravchenko
 */

public class LocatorServiceBean implements IServiceLocator {

    @NotNull
    private final ITerminalService terminalService = new TerminalService();

    @NotNull
    private final ISessionService sessionService = new SessionService();

    @NotNull
    private final ITaskService taskService = new TaskService();

    private final IProjectService projectService = new ProjectService(this);

    @NotNull
    private final IUserService userServiceBean = new UserService(this);

    public LocatorServiceBean() throws Exception {
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

}
