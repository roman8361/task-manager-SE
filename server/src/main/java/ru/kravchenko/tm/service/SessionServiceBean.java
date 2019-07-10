package ru.kravchenko.tm.service;

import lombok.Getter;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ISessionService;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.exception.AccessForbiddenException;
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
    }

    @Override
    public Session findOne(@NotNull final String sessionId) {
        return serviceLocator.getSessionRepository().findById(sessionId);

    }

    @Override
    public void remove(@NotNull final String sessionId) {
    }

    @Override
    public Collection<Session> findAll() {
        return null;
    }

    @Override
    public Session createSession(@NotNull final String userId) throws Exception {
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
//        if (session.getTimestamp() == null) throw new AccessForbiddenException("Access forbidden");
        if (session.getId() == null) throw new AccessForbiddenException("Access forbidden");
        if (!session.getSignature().equals(findOne(session.getId()).getSignature()))
            throw new AccessForbiddenException("Access forbidden");
        System.out.println("SESSION VALID");
    }

    @Override
    @SneakyThrows
    public Session findOnByUserId(@Nullable final String userId) {
        if (userId == null || userId.isEmpty()) return null;
        return serviceLocator.getSessionRepository().findByUserId(userId);
    }

}
