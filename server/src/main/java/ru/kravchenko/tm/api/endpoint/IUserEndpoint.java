package ru.kravchenko.tm.api.endpoint;

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
public interface IUserEndpoint {

    @WebMethod
    void registryUser(
            @WebParam(name = "login") final String login,
            @WebParam(name = "password") final String password) throws UserLoginBusyException;

    @WebMethod
    void authorization(
            @WebParam(name = "login") final String login,
            @WebParam(name = "password") final String password) throws UserNotFoundException;

    @WebMethod
    void logout(
            @WebParam(name = "sessionDTO") final SessionDTO sessionDTO);

}
