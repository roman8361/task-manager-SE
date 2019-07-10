package ru.kravchenko.tm.api;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.endpoint.*;

/**
 * @author Roman Kravchenko
 */

public interface IEndpointServiceLocator {

    ProjectEndpoint getProjectEndpoint();

    TaskEndpoint getTaskEndpoint();

    UserEndpoint getUserEndpoint();

    SessionEndpoint getSessionEndpoint();

    ITerminalService getTerminalService();

    Session getSession();

    void setSession(@NotNull final Session session);

}
