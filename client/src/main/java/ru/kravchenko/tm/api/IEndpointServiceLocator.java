package ru.kravchenko.tm.api;

import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.endpoint.*;

/**
 * @author Roman Kravchenko
 */

public interface IEndpointServiceLocator {

    ProjectEndpoint getProjectEndpoint();

    TaskEndpoint getTaskEndpoint();

    UserEndpoint getUserEndpoint();

    SessionEndpoint getSessionEndpoint();

    ServerEndpoint getServerEndpoint();

    ITerminalService getTerminalService();

    SessionDTO getCurrentSession();

    void setCurrentSession(@Nullable final SessionDTO sessionDTO);

}
