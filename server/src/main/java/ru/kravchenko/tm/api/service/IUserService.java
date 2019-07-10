package ru.kravchenko.tm.api.service;

import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.exception.UserLoginBusyException;
import ru.kravchenko.tm.exception.UserNotFoundException;

/**
 * @author Roman Kravchenko
 */

public interface IUserService {

    boolean checkLoginPassword(@Nullable final String login,
                               @Nullable final String password);

    boolean existLogin(@Nullable final String login);

    void registry(
            @Nullable final String login,
            @Nullable final String password) throws UserLoginBusyException;

    void displayName(@Nullable final String userId) throws UserNotFoundException;

    void authorization(@Nullable final String login,
                       @Nullable final String password
    ) throws UserNotFoundException;

    void logout(final String userId);
}
