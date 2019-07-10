package ru.kravchenko.tm.bootstrap;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kravchenko.tm.api.endpoint.*;
import ru.kravchenko.tm.api.service.IPropertyService;
import ru.kravchenko.tm.exception.AccessForbiddenException;
import ru.kravchenko.tm.exception.UserLoginBusyException;
import ru.kravchenko.tm.exception.UserNotFoundException;

import javax.xml.ws.Endpoint;

/**
 * @author Roman Kravchenko
 */

@Component
@NoArgsConstructor
public class Bootstrap {

    @NotNull
    @Autowired
    private IUserEndpoint userEndpoint;

    @NotNull
    @Autowired
    private ISessionEndpoint sessionEndpoint;

    @NotNull
    @Autowired
    private IProjectEndpoint projectEndpoint;

    @NotNull
    @Autowired
    private ITaskEndpoint taskEndpoint;

    @NotNull
    @Autowired
    private IServerEndpoint serverEndpoint;

    @NotNull
    @Autowired
    private IPropertyService propertyService;

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
    }

}
