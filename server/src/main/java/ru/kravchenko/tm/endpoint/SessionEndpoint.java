package ru.kravchenko.tm.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.kravchenko.tm.api.endpoint.ISessionEndpoint;
import ru.kravchenko.tm.api.service.ISessionService;
import ru.kravchenko.tm.api.service.IUserService;
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
@Controller
public class SessionEndpoint implements ISessionEndpoint {

    @NotNull
    @Autowired
    private IUserService userService;

    @NotNull
    @Autowired
    private ISessionService sessionService;

    @Override
    @WebMethod
    public SessionDTO openSession(@WebParam(name = "login", partName = "login")
                                  @NotNull final String login) throws UserNotFoundException, SessionNotFoundException {
        final User user = userService.findByLogin(login);
        if (user == null) throw new UserNotFoundException();
        final Session session = sessionService.findOnByUserId(user.getId());
        if (session == null) throw new SessionNotFoundException();
        return session.getDTO();
    }

    @Override
    @WebMethod
    public void validateSession(@WebParam(name = "sessionDTO")
                                @Nullable final SessionDTO sessionDTO) throws AccessForbiddenException {
        sessionService.validate(sessionDTO);
    }

    @Override
    @WebMethod
    public void validateAdminSession(@Nullable final Session session) {

    }

    @Override
    @WebMethod
    public void closeSession(@WebParam(name = "session")
                             @NotNull final Session session) {
        if (sessionService.exist(session.getId())) {
            sessionService.removeById(session.getId());
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
        return userService.findById(session.getUser().getId());
    }

}
