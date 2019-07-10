package ru.kravchenko.tm.api.reposiroty;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.User;
import ru.kravchenko.tm.exception.UserNotFoundException;

import java.util.Collection;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

public interface IUserRepository {

    @Nullable
    User findByLogin(@Nullable final String login) throws UserNotFoundException;

    User findByUserId(@NotNull final String userId);

    void showAllUsers();

    void addUser(@Nullable final User user);

    void removeByLogin(@Nullable final String login);

    void putUser(@NotNull final User user);

    @NotNull
    Collection<User> findAll();

//    boolean existUser(@NotNull final String userId);

}
