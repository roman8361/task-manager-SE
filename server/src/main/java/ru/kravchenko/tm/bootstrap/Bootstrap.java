package ru.kravchenko.tm.bootstrap;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.endpoint.IProjectEndpoint;
import ru.kravchenko.tm.api.endpoint.ISessionEndpoint;
import ru.kravchenko.tm.api.endpoint.ITaskEndpoint;
import ru.kravchenko.tm.api.endpoint.IUserEndpoint;
import ru.kravchenko.tm.api.service.ISessionService;
import ru.kravchenko.tm.exception.UserLoginBusyException;
import ru.kravchenko.tm.exception.UserNotFoundException;
import ru.kravchenko.tm.model.entity.Session;
import ru.kravchenko.tm.model.entity.User;
import ru.kravchenko.tm.repository.UserRepositoryDAO;
import ru.kravchenko.tm.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.xml.ws.Endpoint;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class Bootstrap {

    @Inject
    @NotNull
    private IUserEndpoint userEndpoint;

    @Inject
    @NotNull
    private ISessionEndpoint sessionEndpoint;

    @Inject
    @NotNull
    private IProjectEndpoint projectEndpoint;

    @Inject
    @NotNull
    private ITaskEndpoint taskEndpoint;

    public Bootstrap() throws Exception {
    }

    private void registry(final Object endpoint) {
        if (endpoint == null) return;
        final String name = endpoint.getClass().getSimpleName();
        final String wsdl = "http://localhost:8080/" + name + "?WSDL";
        System.out.println(wsdl);
        Endpoint.publish(wsdl, endpoint);
    }

    public void init() throws UserLoginBusyException, UserNotFoundException {
        System.out.println("SERVER START");
        registry(userEndpoint);
        registry(sessionEndpoint);
        registry(projectEndpoint);
        registry(taskEndpoint);
    }

}
