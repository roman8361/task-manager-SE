package ru.kravchenko.tm.endpoint;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.endpoint.IServerEndpoint;
import ru.kravchenko.tm.api.service.IPropertyService;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Roman Kravchenko
 */

@WebService
public class ServerEndpoint implements IServerEndpoint {

    @Inject
    @NotNull
    private IPropertyService propertyService;

    @Override
    @WebMethod
    public String getInfoHost() {
        return propertyService.getServerHost();
    }

    @Override
    @WebMethod
    public String getInfoPort() {
        return propertyService.getServerPort();
    }

}