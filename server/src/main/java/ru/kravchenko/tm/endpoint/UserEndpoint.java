package ru.kravchenko.tm.endpoint;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.kravchenko.tm.api.endpoint.IUserEndpoint;
import ru.kravchenko.tm.api.service.ISessionService;
import ru.kravchenko.tm.api.service.IUserService;
import ru.kravchenko.tm.exception.UserLoginBusyException;
import ru.kravchenko.tm.exception.UserNotFoundException;
import ru.kravchenko.tm.model.dto.SessionDTO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Roman Kravchenko
 */

@WebService
@Controller
public class UserEndpoint implements IUserEndpoint {

    @Autowired
    private IUserService userService;

    @Autowired
    private ISessionService sessionService;

    @Override
    @WebMethod
    public void registryUser(@WebParam(name = "login") final String login,
                             @WebParam(name = "password") final String password) throws UserLoginBusyException {
        userService.registry(login, password);
        System.out.println("NEW USER ADD TO REPOSITORY: " + login);
    }

    @Override
    @WebMethod
    public void authorization(@WebParam(name = "login") final String login,
                              @WebParam(name = "password") final String password) throws UserNotFoundException {
        userService.authorization(login, password);
        System.out.println("USER AUTORIZATION: " + login);
    }

    @Override
    @WebMethod
    public void logout(@WebParam(name = "sessionDTO") @NotNull final SessionDTO sessionDTO) {
        System.out.println("ID SESSION DTO: " + sessionDTO.getId());
        sessionService.removeById(sessionDTO.getId());
        System.out.println("USER LOGOUT");
    }

}
