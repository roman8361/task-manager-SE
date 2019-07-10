package ru.kravchenko.tm.repository;

import lombok.NoArgsConstructor;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.repository.SessionRepository;
import ru.kravchenko.tm.api.repository.UserRepository;
import ru.kravchenko.tm.api.repository.old.ISessionRepository;
import ru.kravchenko.tm.model.entity.Session;
import ru.kravchenko.tm.model.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Transactional
@ApplicationScoped
@NoArgsConstructor
public class SessionRepositoryDAO implements ISessionRepository {

    @Inject
    @NotNull
    private SessionRepository sessionRepository;

    @Inject
    @NotNull
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
        return sessionRepository.findBy(id);
    }

    @Override
    public Session findOnByUserId(@NotNull final String userId) {
        final User user = userRepository.findBy(userId);
        final Session session = sessionRepository.findByUser(user).get(0);
        return session;
    }

    @Override
    public void removeById(@NotNull final String id) {
        sessionRepository.removeById(id);
    }

    @Override
    public void insert(@NotNull final Session session) {
        sessionRepository.persist(session);
    }

    @Override
    public void clear() {
        sessionRepository.removeAll();
    }

}
