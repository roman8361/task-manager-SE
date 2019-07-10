package ru.kravchenko.tm.api.reposiroty;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.User;

import java.util.Collection;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

public interface IUserRepository {

    @Nullable
    User findByLogin(@Nullable final String login, final Map map);

    void showAllUsers(final Map map);

    void addUser(@Nullable final String userLogin,
                 final User user,
                 final Map map);

    void removeById(@Nullable final String userLogin, @NotNull final Map map);

    @NotNull
    Collection<User> findAll(@Nullable final Map map);

    boolean existUser(@NotNull final String userLogin);

}
