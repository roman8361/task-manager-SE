package ru.kravchenko.tm.bootstrap;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.endpoint.IProjectEndpoint;
import ru.kravchenko.tm.api.endpoint.ISessionEndpoint;
import ru.kravchenko.tm.api.endpoint.ITaskEndpoint;
import ru.kravchenko.tm.api.endpoint.IUserEndpoint;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.endpoint.ProjectEndpoint;
import ru.kravchenko.tm.endpoint.SessionEndpoint;
import ru.kravchenko.tm.endpoint.TaskEndpoint;
import ru.kravchenko.tm.endpoint.UserEndpoint;
import ru.kravchenko.tm.exception.AccessForbiddenException;
import ru.kravchenko.tm.exception.SessionNotFoundException;
import ru.kravchenko.tm.exception.UserLoginBusyException;
import ru.kravchenko.tm.exception.UserNotFoundException;
import ru.kravchenko.tm.service.LocatorServiceBean;

import javax.xml.ws.Endpoint;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class Bootstrap {

    @NotNull
    private IServiceLocator serviceLocator = new LocatorServiceBean();

    @NotNull
    private IUserEndpoint userEndpoint = new UserEndpoint(serviceLocator);

    @NotNull
    private ISessionEndpoint sessionEndpoint = new SessionEndpoint(serviceLocator);

    @NotNull
    private IProjectEndpoint projectEndpoint = new ProjectEndpoint(serviceLocator);

    @NotNull
    private ITaskEndpoint taskEndpoint = new TaskEndpoint(serviceLocator);

    public Bootstrap() throws Exception {
    }

    private void registry(final Object endpoint) {
        if (endpoint == null) return;
        final String name = endpoint.getClass().getSimpleName();
        final String wsdl = "http://localhost:8080/" + name + "?WSDL";
        System.out.println(wsdl);
        Endpoint.publish(wsdl, endpoint);
    }

    public void init() {
        System.out.println("SERVER START");
        registry(userEndpoint);
        registry(sessionEndpoint);
        registry(projectEndpoint);
        registry(taskEndpoint);
    }

}
