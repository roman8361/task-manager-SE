package ru.kravchenko.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Roman Kravchenko
 */

public interface IUserService {

    boolean check(
            @Nullable final String login,
            @Nullable final String password
    );

    boolean registry(
            @Nullable final String login,
            @Nullable final String password);

    boolean existsDateBase(@Nullable final String login);

    boolean existsLoginBase(@Nullable final String login);

    boolean setPassword(
            @Nullable final String login,
            @Nullable final String passwordOld,
            @Nullable final String passwordNew
    );

    void displayName(@Nullable final String login);

    void authorization(
            @Nullable final String login,
            @Nullable final String password
    );

    void logout(@Nullable final String login);

    void changePasswordUser(@Nullable final String login,
                            @NotNull final String newPassword);

    void changeProfileUser(@Nullable final String loginOld,
                           @Nullable final String loginNew,
                           @Nullable final String newLogin);

}
