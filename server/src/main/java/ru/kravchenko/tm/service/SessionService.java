package ru.kravchenko.tm.service;

import com.sun.istack.internal.Nullable;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.repository.ISessionRepository;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ISessionService;
import ru.kravchenko.tm.exception.AccessForbiddenException;
import ru.kravchenko.tm.model.dto.SessionDTO;
import ru.kravchenko.tm.model.entity.Session;
import ru.kravchenko.tm.model.entity.User;
import ru.kravchenko.tm.util.SignatureUtil;

import java.util.Date;
import java.util.List;

/**
 * @author Roman Kravchenko
 */


public class SessionService implements ISessionService {

    private final IServiceLocator serviceLocator;

    private final ISessionRepository sessionRepository;

    public SessionService(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        this.sessionRepository = serviceLocator.getSessionRepository();
    }


    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    public List<String> ids() {
        return sessionRepository.ids();
    }

    public Session findById(@Nullable final String id) {
        return sessionRepository.findOne(id);
    }

    public void removeById(@Nullable final String id) {
        sessionRepository.removeById(id);
    }

    public void insert(@Nullable final Session session) {
        sessionRepository.insert(session);
    }

    public Session findOnByUserId(final String userId) {
        if (userId == null || userId.isEmpty()) return null;
        return sessionRepository.findOnByUserId(userId);
    }

    public void clear() {
        sessionRepository.clear();
    }


    @Override
    public void addSession(@NotNull final Session session) {
        if (session == null) return;
        if (session.getId() == null || session.getId().isEmpty()) return;
        insert(session);
    }

    @Override
    public SessionDTO createSession(@NotNull final String userId) {
        @NotNull final Integer cycle = 5;
        @NotNull final String salt = "salt";
        @NotNull final SessionDTO session = new SessionDTO();
        session.setTimestamp(new Date());
        @NotNull final User user = serviceLocator.getUserRepository().findById(userId);
        session.setUserId(user.getId());
        session.setSignature(SignatureUtil.sign(session, salt, cycle));
        addSession(convertDTOtoSession(session));
        return session;
    }

    private Session convertDTOtoSession(@Nullable final SessionDTO sessionDTO) {
        final Session session = new Session();
        session.setId(sessionDTO.getId());
        session.setSignature(sessionDTO.getSignature());
        session.setTimestamp(sessionDTO.getTimestamp());
        final User user = serviceLocator.getUserService().findById(sessionDTO.getUserId());
        session.setUser(user);
        return session;
    }


    @Override
    public void validate(@Nullable final SessionDTO sessionDTO) throws AccessForbiddenException {
        if (sessionDTO == null) throw new AccessForbiddenException("Access forbidden");
        if (sessionDTO.getSignature() == null) throw new AccessForbiddenException("Access forbidden");
        if (sessionDTO.getTimestamp() == null) throw new AccessForbiddenException("Access forbidden");
        if (sessionDTO.getId() == null) throw new AccessForbiddenException("Access forbidden");
        if (!sessionDTO.getSignature().equals(findById(sessionDTO.getId()).getDTO().getSignature()))
            throw new AccessForbiddenException("Access forbidden");
        System.out.println("SESSION VALID");
    }

    @Override
    public boolean exist(@NotNull final String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) return false;
        if (findById(sessionId) == null) return false;
        return true;
    }

}
