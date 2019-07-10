package ru.kravchenko.tm.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
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

    public UserEndpoint userEndpoint = new UserEndpointService().getUserEndpointPort();

    public SessionEndpoint sessionEndpoint = new SessionEndpointService().getSessionEndpointPort();

    public ProjectEndpoint projectEndpoint = new ProjectEndpointService().getProjectEndpointPort();

    public TaskEndpoint taskEndpoint = new TaskEndpointService().getTaskEndpointPort();

    @Nullable
    private SessionDTO sessionDTO;

    @Override
    public SessionDTO getCurrentSession() {
        return sessionDTO;
    }

    @Override
    public void setCurrentSession(
            @Nullable final SessionDTO sessionDTO) {
        this.sessionDTO = sessionDTO;
    }


}
