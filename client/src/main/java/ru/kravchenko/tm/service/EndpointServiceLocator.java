package ru.kravchenko.tm.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kravchenko.tm.api.IEndpointServiceLocator;
import ru.kravchenko.tm.api.ITerminalService;
import ru.kravchenko.tm.endpoint.*;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@NoArgsConstructor
public class EndpointServiceLocator implements IEndpointServiceLocator {

    public ITerminalService terminalService = new TerminalService();

    public ProjectEndpoint projectEndpoint = new ProjectEndpointService().getProjectEndpointPort();

    public UserEndpoint userEndpoint = new UserEndpointService().getUserEndpointPort();

    public SessionEndpoint sessionEndpoint = new SessionEndpointService().getSessionEndpointPort();

    public TaskEndpoint taskEndpoint = new TaskEndpointService().getTaskEndpointPort();

    private Session session;

}
