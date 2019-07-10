package ru.kravchenko.tm.exception.api;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.exception.model.User;

/**
 * @author Roman Kravchenko
 */

public interface UserRepository {

    User find(@NotNull final String id);

    User get(@NotNull final String id);

}
