package ru.kravchenko.tm.api.service;

import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.User;
import ru.kravchenko.tm.exception.UserLoginBusyException;
import ru.kravchenko.tm.exception.UserNotFoundException;

/**
 * @author Roman Kravchenko
 */
public interface IUserService {

    void registry(@Nullable final String login,
                  @Nullable final String password) throws UserLoginBusyException;

    boolean existLogin(@Nullable final String login);

    void authorization(@Nullable final String login,
                       @Nullable final String password) throws UserNotFoundException;

    boolean checkLoginPassword(@Nullable final String login, @Nullable final String password);

    User findByLogin(final String login);

    User findById(@Nullable final String id);

    void logout(@Nullable final String userId);

}
