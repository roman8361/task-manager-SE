package ru.kravchenko.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.entity.User;
import ru.kravchenko.tm.exception.AccessForbiddenException;
import ru.kravchenko.tm.exception.SessionNotFoundException;
import ru.kravchenko.tm.exception.UserNotFoundException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@WebService
public interface ISessionEndpoint {

    @WebMethod
    Session openSession(
            @WebParam(name = "login", partName = "login") @NotNull final String login) throws UserNotFoundException;

    @WebMethod
    void validateSession(@WebParam(name = "session") @Nullable final Session session) throws SessionNotFoundException, AccessForbiddenException;

    @WebMethod
    void validateAdminSession(@WebParam(name = "session") @Nullable final Session session);

    @WebMethod
    void closeSession(@WebParam(name = "session") @NotNull final Session session) throws SessionNotFoundException;

    @WebMethod
    List<Session> getListSession(@WebParam(name = "session", partName = "session") Session session) throws SessionNotFoundException;

    User getUser(@WebParam(name = "session", partName = "session") Session session) throws SessionNotFoundException;

}
