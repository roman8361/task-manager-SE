package ru.kravchenko.tm.api.service;

import ru.kravchenko.tm.api.reposiroty.IProjectRepository;
import ru.kravchenko.tm.api.reposiroty.ITaskRepository;
import ru.kravchenko.tm.api.reposiroty.IUserRepository;

/**
 * @author Roman Kravchenko
 */

public interface IServiceLocator {

    IProjectService getProjectService();

    ITaskService getTaskService();

    IUserService getUserService();

    ITerminalService getTerminalService();

    IUserRepository getUserRepository();

    ITaskRepository getTaskRepository();

    IProjectRepository getProjectRepository();

    IAbout getAbout();

}
