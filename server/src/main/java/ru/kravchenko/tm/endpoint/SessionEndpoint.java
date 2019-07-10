package ru.kravchenko.tm.endpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.endpoint.ISessionEndpoint;
import ru.kravchenko.tm.api.service.IServiceLocator;
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
@NoArgsConstructor
public class SessionEndpoint implements ISessionEndpoint {

    @NotNull
    private IServiceLocator serviceLocator;

    public SessionEndpoint(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    @WebMethod
    public SessionDTO openSession(@WebParam(name = "login", partName = "login")
                                  @NotNull final String login) throws UserNotFoundException, SessionNotFoundException {
        final User user = serviceLocator.getUserService().findByLogin(login);
        if (user == null) throw new UserNotFoundException();
        final Session session = serviceLocator.getSessionService().findOnByUserId(user.getId());
        if (session == null) throw new SessionNotFoundException();
        return session.getDTO();
    }

    @Override
    @WebMethod
    public void validateSession(@WebParam(name = "sessionDTO")
                                @Nullable final SessionDTO sessionDTO) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(sessionDTO);
    }

    @Override
    @WebMethod
    public void validateAdminSession(@Nullable final Session session) {

    }

    @Override
    @WebMethod
    public void closeSession(@WebParam(name = "session")
                             @NotNull final Session session) {
        if (serviceLocator.getSessionService().exist(session.getId())) {
            serviceLocator.getSessionService().removeById(session.getId());
        }
    }

    @Override
    @WebMethod
    public List<Session> getListSession(@Nullable final Session session) {
        return null;
    }

    @Override
    @WebMethod
    public User getUser(@Nullable final Session session) {
        assert session != null;
        if (session.getUser().getId() == null) return null;
        return serviceLocator.getUserService().findById(session.getUser().getId());
    }

    @Override
    public String test(@NotNull String login) {
        return login + " your login";
    }

}
