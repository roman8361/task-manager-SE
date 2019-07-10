package ru.kravchenko.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.exception.AccessForbiddenException;
import ru.kravchenko.tm.exception.SessionNotFoundException;
import ru.kravchenko.tm.exception.UserNotFoundException;
import ru.kravchenko.tm.model.dto.SessionDTO;
import ru.kravchenko.tm.model.entity.Session;
import ru.kravchenko.tm.model.entity.User;

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
    SessionDTO openSession(
            @WebParam(name = "login", partName = "login") @NotNull final String login) throws UserNotFoundException, SessionNotFoundException;

    @WebMethod
    void validateSession(@WebParam(name = "sessionDTO") @Nullable final SessionDTO sessionDTO) throws AccessForbiddenException;

    @WebMethod
    void validateAdminSession(@WebParam(name = "session") @Nullable final Session session);

    @WebMethod
    void closeSession(@WebParam(name = "session") @NotNull final Session session);

    @WebMethod
    List<Session> getListSession(@WebParam(name = "session", partName = "session") Session session) throws SessionNotFoundException;

    User getUser(@WebParam(name = "session", partName = "session") Session session);

    String test(@WebParam(name = "login", partName = "login") @NotNull final String login);

}
