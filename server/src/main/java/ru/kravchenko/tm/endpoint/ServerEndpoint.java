package ru.kravchenko.tm.endpoint;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.kravchenko.tm.api.endpoint.IServerEndpoint;
import ru.kravchenko.tm.api.service.IPropertyService;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Roman Kravchenko
 */

@WebService
@Controller
public class ServerEndpoint implements IServerEndpoint {

    @NotNull
    @Autowired
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