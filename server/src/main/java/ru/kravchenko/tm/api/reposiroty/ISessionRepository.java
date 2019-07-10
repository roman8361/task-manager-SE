package ru.kravchenko.tm.api.reposiroty;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.Session;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

public interface ISessionRepository {

    Session findById(@Nullable final String sessionId);

    @NotNull
    List<Session> findAll();

    void removeById(@Nullable final String sessionId);

    void addSession(@NotNull final Session session);

    void removeAll();

    void showAllSession();

    boolean exist(@NotNull final String idSession);

    Session findByUserId(String userId);

}
