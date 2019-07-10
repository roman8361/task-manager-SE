package ru.kravchenko.tm.service;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ISessionService;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.exception.AccessForbiddenException;
import ru.kravchenko.tm.exception.SessionNotFoundException;
import ru.kravchenko.tm.util.SignatureUtil;

import java.util.Collection;
import java.util.Date;

/**
 * @author Roman Kravchenko
 */

@Getter
public class SessionServiceBean implements ISessionService {

    @NotNull
    private IServiceLocator serviceLocator;

    public SessionServiceBean(@NotNull IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public void clear() {
        serviceLocator.getSessionRepository().removeAll();
    }

    @Override
    public Session findOne(@NotNull final String sessionId) {
        return serviceLocator.getSessionRepository().findById(sessionId);
    }

    @Override
    public void remove(@NotNull final String sessionId) {
        serviceLocator.getSessionRepository().removeById(sessionId);
    }

    @Override
    public Collection<Session> findAll() {
        return serviceLocator.getSessionRepository().findAll();
    }

    @Override
    public Session createSession(@NotNull final String userId) {
        @NotNull final Integer cycle = 5;
        @NotNull final String salt = "salt";
        @NotNull final Session session = new Session();
        session.setTimestamp(new Date());
        session.setUserId(userId);
        session.setSignature(SignatureUtil.sign(session, salt, cycle));
        serviceLocator.getSessionRepository().addSession(session);
        return session;
    }

    @Override
    public void validate(@Nullable final Session session) throws AccessForbiddenException {
        if (session == null) throw new AccessForbiddenException("Access forbidden");
        if (session.getSignature() == null) throw new AccessForbiddenException("Access forbidden");
        if (session.getUserId() == null) throw new AccessForbiddenException("Access forbidden");
        if (session.getTimestamp() == null) throw new AccessForbiddenException("Access forbidden");
        if (session.getId() == null) throw new AccessForbiddenException("Access forbidden");
        if (!session.getSignature().equals(findOne(session.getId()).getSignature()))
            throw new AccessForbiddenException("Access forbidden");
        System.out.println("SESSION VALID");
    }

    @Override
    public Session findOnByUserId(@Nullable final String userId) {
        if (userId == null || userId.isEmpty()) return null;
        for (final Session session : serviceLocator.getSessionRepository().findAll()) {
            if (userId.equals(session.getUserId())) {
                return session;
            }
        }
        return null;
    }

    @Override
    public void closeSession(@NotNull final Session session) throws SessionNotFoundException {
        if (serviceLocator.getSessionRepository().exist(session.getId())) {
            serviceLocator.getSessionRepository().removeById(session.getId());
            serviceLocator.getSessionRepository().showAllSession();
            return;
        }
        throw new SessionNotFoundException();
    }

}
