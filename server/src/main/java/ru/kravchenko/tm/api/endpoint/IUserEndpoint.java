package ru.kravchenko.tm.api.endpoint;

import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.entity.User;
import ru.kravchenko.tm.exception.SessionNotFoundException;
import ru.kravchenko.tm.exception.UserLoginBusyException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Roman Kravchenko
 */

@WebService
public interface IUserEndpoint {

    @WebMethod
    void createUser(
            @WebParam(name = "login") final String login,
            @WebParam(name = "password") final String password) throws UserLoginBusyException;

    @WebMethod
    void authorization(
            @WebParam(name = "login") final String login,
            @WebParam(name = "password") final String password);

    @WebMethod
    void logout(
            @WebParam(name = "session") final Session session) throws SessionNotFoundException;

}
