package ru.kravchenko.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.exception.AccessForbiddenException;

import java.util.Collection;

/**
 * @author Roman Kravchenko
 */

public interface ISessionService {

    void clear();

    Session findOne(@NotNull final String sessionId);

    void remove(@NotNull final String sessionId);

    Collection<Session> findAll();

    Session createSession(@NotNull final String userId) throws Exception;

    void validate(@Nullable final Session session) throws AccessForbiddenException;

    Session findOnByUserId(@Nullable final String userId);

}
