package ru.kravchenko.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.User;

/**
 * @author Roman Kravchenko
 */

public interface UserService {

    @Nullable
    User findByLogin(@Nullable String login);

    boolean check(
            @Nullable String login,
            @Nullable String password
    );

    boolean registry(
            @Nullable String login,
            @Nullable String password
    );

    boolean existsDateBase(@Nullable String login);

    boolean existsLoginBase(@Nullable String login);

    boolean setPassword(
            @Nullable String login,
            @Nullable String passwordOld,
            @Nullable String passwordNew
    );

    void displayName(@Nullable String login);

    void authorization(
            @Nullable String login,
            @Nullable String password
    );

    void logout(@Nullable String login);

    void changePasswordUser(@Nullable String login,
                            @NotNull String newPassword);

    void changeProfileUser(@Nullable String loginOld,
                           @Nullable String loginNew,
                           @Nullable String newLogin);

}
