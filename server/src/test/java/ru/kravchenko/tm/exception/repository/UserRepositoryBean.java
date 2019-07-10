package ru.kravchenko.tm.exception.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.exception.api.UserRepository;
import ru.kravchenko.tm.exception.exception.UserNotFoundException;
import ru.kravchenko.tm.exception.model.User;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */
public class UserRepositoryBean implements UserRepository {

    @Nullable
    private final Map<String, User> users = new LinkedHashMap<>();

    @Override
    public User find(@NotNull final String id) {
        if (!users.containsKey(id)) throw new UserNotFoundException();
        return users.get(id);
    }

    @Override
    public User get(@NotNull final String id) {
        if (id == null || id.isEmpty()) return null;
        return users.get(id);
    }

}
