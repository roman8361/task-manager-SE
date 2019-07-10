package ru.kravchenko.tm.repository;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.reposiroty.ISessionRepository;
import ru.kravchenko.tm.entity.Session;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class SessionRepositoryBean implements ISessionRepository {

    @Nullable
    private Map<String, Session> sessionRepository = new LinkedHashMap<>();

    @Override
    public Session findById(@Nullable final String sessionId) {
        assert sessionRepository != null;
        final Session session = sessionRepository.get(sessionId);
        return session;
    }

    @NotNull
    @Override
    public Collection<Session> findAll() {
        assert sessionRepository != null;
        return sessionRepository.values();
    }

    @Override
    public void removeById(@Nullable final String sessionId) {
        assert sessionRepository != null;
        sessionRepository.remove(sessionId);
    }

    @Override
    public void addSession(@NotNull final Session session) {
        assert sessionRepository != null; // спросить у Дениса, что это такое?
        sessionRepository.put(session.getId(), session);
    }

    @Override
    public void removeAll() {
        sessionRepository.clear();
    }

    @Override
    public void showAllSession() {
        System.out.println(findAll());
    }

    @Override
    public boolean exist(@NotNull final String idSession) {
        if (idSession == null || idSession.isEmpty()) return false;
        if (sessionRepository == null) return false;
        return sessionRepository.containsKey(idSession);
    }

}
