package ru.kravchenko.tm.service;

import com.sun.istack.internal.Nullable;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.service.ISessionService;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.exception.AccessForbiddenException;
import ru.kravchenko.tm.repository.SessionRepository;
import ru.kravchenko.tm.util.SignatureUtil;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

public class SessionService extends AbstractService implements ISessionService {

    private final SessionRepository sessionRepository;

    public SessionService() throws IOException {
        sessionRepository = sqlSession.getMapper(SessionRepository.class);
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
        try {
            sessionRepository.removeById(id);
            commit();
        } catch (Exception e) {
            roolback();
            e.printStackTrace();
        }
    }

    public void insert(@Nullable final Session session) {
        try {
            sessionRepository.insert(session);
            commit();
        } catch (Exception e) {
            roolback();
            e.printStackTrace();
        }
    }

    public Session findOnByUserId(final String userId) {
        if (userId == null || userId.isEmpty()) return null;
        return sessionRepository.findOnByUserId(userId);
    }

    public void clear() {
        try {
            sessionRepository.clear();
            commit();
        } catch (Exception e) {
            roolback();
            e.printStackTrace();
        }
    }

    public void commit() {
        sqlSession.commit();
    }

    public void roolback() {
        sqlSession.rollback();
    }

    @Override
    public void addSession(@NotNull final Session session) {
        if (session == null) return;
        if (session.getId() == null || session.getId().isEmpty()) return;
        insert(session);
        commit();
    }

    @Override
    public Session createSession(@NotNull final String userId) {
        @NotNull final Integer cycle = 5;
        @NotNull final String salt = "salt";
        @NotNull final Session session = new Session();
        session.setTimestamp(new Date());
        session.setUserId(userId);
        session.setSignature(SignatureUtil.sign(session, salt, cycle));
        addSession(session);
        return session;
    }

    @Override
    public void validate(@Nullable final Session session) throws AccessForbiddenException {
        if (session == null) throw new AccessForbiddenException("Access forbidden");
        if (session.getSignature() == null) throw new AccessForbiddenException("Access forbidden");
        //     if (session.getUserId() == null) throw new AccessForbiddenException("Access forbidden");
        if (session.getTimestamp() == null) throw new AccessForbiddenException("Access forbidden");
        if (session.getId() == null) throw new AccessForbiddenException("Access forbidden");
        if (!session.getSignature().equals(findById(session.getId()).getSignature()))
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
