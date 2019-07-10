package ru.kravchenko.tm.bootstrap;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.endpoint.*;
import ru.kravchenko.tm.api.service.IPropertyService;
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

    @Inject
    @NotNull
    private IServerEndpoint serverEndpoint;

    @Inject
    @NotNull
    private IPropertyService propertyService;

    public Bootstrap() {
    }

    private void registry(final Object endpoint) {
        if (endpoint == null) return;
        final String name = endpoint.getClass().getSimpleName();
        @NotNull final String URL = propertyService.getServerHost();
        @NotNull final String PORT = propertyService.getServerPort();
        final String wsdl = URL + ":" + PORT + "/" + name + "?WSDL";
        System.out.println(wsdl);
        Endpoint.publish(wsdl, endpoint);
    }

    public void init() {
        System.out.println("SERVER START");
        registry(userEndpoint);
        registry(sessionEndpoint);
        registry(projectEndpoint);
        registry(taskEndpoint);
        registry(serverEndpoint);
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
    }

}
