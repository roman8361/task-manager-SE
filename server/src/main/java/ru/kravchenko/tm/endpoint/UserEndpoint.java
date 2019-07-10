package ru.kravchenko.tm.endpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.endpoint.IUserEndpoint;
import ru.kravchenko.tm.api.service.IServiceLocator;
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
@NoArgsConstructor
public class UserEndpoint implements IUserEndpoint {

    @NotNull
    private IServiceLocator serviceLocator;

    public UserEndpoint(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    @WebMethod
    public void registryUser(@WebParam(name = "login") final String login,
                             @WebParam(name = "password") final String password) throws UserLoginBusyException {
        serviceLocator.getUserService().registry(login, password);
        System.out.println("NEW USER ADD TO REPOSITORY: " + login);
    }

    @Override
    @WebMethod
    public void authorization(@WebParam(name = "login") final String login,
                              @WebParam(name = "password") final String password) throws UserNotFoundException {
        serviceLocator.getUserService().authorization(login, password);
        System.out.println("USER AUTORIZATION: " + login);
    }

    @Override
    @WebMethod
    public void logout(@WebParam(name = "sessionDTO") @NotNull final SessionDTO sessionDTO) {
        System.out.println("ID SESSION DTO: " + sessionDTO.getId());
        serviceLocator.getSessionService().removeById(sessionDTO.getId());
        System.out.println("USER LOGOUT");
    }

}
