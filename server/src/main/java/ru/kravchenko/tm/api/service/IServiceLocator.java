package ru.kravchenko.tm.api.service;

import ru.kravchenko.tm.api.repository.IProjectRepository;
import ru.kravchenko.tm.api.repository.ISessionRepository;
import ru.kravchenko.tm.api.repository.ITaskRepository;
import ru.kravchenko.tm.api.repository.IUserRepository;

/**
 * @author Roman Kravchenko
 */

public interface IServiceLocator {

    IUserRepository getUserRepository();

    IUserService getUserService();

    ISessionRepository getSessionRepository();

    ISessionService getSessionService();

    IProjectRepository getProjectRepository();

    IProjectService getProjectService();

    ITaskRepository getTaskRepository();

    ITaskService getTaskService();

    ITerminalService getTerminalService();

    IAbout getAbout();

    IEntityManager getEntityManager();

}
