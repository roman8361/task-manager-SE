package ru.kravchenko.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.exception.AccessForbiddenException;
import ru.kravchenko.tm.model.dto.SessionDTO;
import ru.kravchenko.tm.model.entity.Session;

/**
 * @author Roman Kravchenko
 */
public interface ISessionService {

    void addSession(@NotNull final Session session);

    SessionDTO createSession(@NotNull final String userId);

    void validate(@Nullable final SessionDTO sessionDTO) throws AccessForbiddenException;

    Session findOnByUserId(@Nullable final String userId);

    boolean exist(@NotNull final String sessionId);

    public void removeById(@Nullable final String id);

    public Session findById(@Nullable final String id);

}
