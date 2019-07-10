package ru.kravchenko.tm.api.service;

/**
 * @author Roman Kravchenko
 */

public interface IServiceLocator {

    IUserService getUserService();

    ISessionService getSessionService();

    IProjectService getProjectService();

    ITaskService getTaskService();

    ITerminalService getTerminalService();

    IAbout getAbout();

}
