package ru.kravchenko.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kravchenko.tm.api.repository.ISessionRepository;
import ru.kravchenko.tm.api.repository.SessionRepository;
import ru.kravchenko.tm.api.repository.UserRepository;
import ru.kravchenko.tm.model.entity.Session;
import ru.kravchenko.tm.model.entity.User;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Service
public class SessionRepositoryDAO implements ISessionRepository {

    @NotNull
    @Autowired
    private SessionRepository sessionRepository;

    @NotNull
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    @Override
    public List<String> ids() {
        return sessionRepository.findAllId();
    }

    @Override
    public Session findById(@NotNull final String id) {
        return sessionRepository.findById(id).get();
    }

    @Override
    public Session findOnByUserId(@NotNull final String userId) {
        final User user = userRepository.findById(userId).get();
        final Session session = sessionRepository.findByUser(user).get(0);
        return session;
    }

    @Override
    @Transactional
    public void removeById(@NotNull final String id) {
        sessionRepository.removeById(id);
    }

    @Override
    public void insert(@NotNull final Session session) {
        sessionRepository.save(session);
    }

    @Override
    public void clear() {
        sessionRepository.deleteAll();
    }

}
