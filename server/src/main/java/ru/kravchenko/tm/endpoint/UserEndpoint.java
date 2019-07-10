package ru.kravchenko.tm.endpoint;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.endpoint.IUserEndpoint;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.exception.SessionNotFoundException;
import ru.kravchenko.tm.exception.UserLoginBusyException;

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
    public void createUser(@WebParam(name = "login") final String login,
                           @WebParam(name = "password") final String password) throws UserLoginBusyException {
        serviceLocator.getUserService().registry(login, password);
        System.out.println("NEW USER ADD TO REPOSITORY: " + login);
    }

    @Override
    @WebMethod
    @SneakyThrows
    public void authorization(@WebParam(name = "login") final String login,
                              @WebParam(name = "password") final String password) {
        serviceLocator.getUserService().authorization(login, password);
        System.out.println("USER AUTORIZATION: " + login);
    }

    @Override
    @WebMethod
    public void logout(@WebParam(name = "session") @NotNull final Session session) throws SessionNotFoundException {
        if (session == null) return;
        serviceLocator.getSessionService().closeSession(session);
        System.out.println("USER LOGOUT");
    }

}
