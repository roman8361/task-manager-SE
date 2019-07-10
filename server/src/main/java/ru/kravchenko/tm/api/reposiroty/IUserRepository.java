package ru.kravchenko.tm.api.reposiroty;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.User;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

public interface IUserRepository {

    @Nullable
    User findByLogin(@Nullable final String login);

    User findByUserId(@NotNull final String userId);

    void showAllUsers() throws Exception;

    void addUser(@Nullable final User user) throws Exception;

    void removeById(@Nullable final String userId) throws Exception;

    @NotNull
    List<User> findAll() throws Exception;

    void removeAllUsers() throws Exception;

}
