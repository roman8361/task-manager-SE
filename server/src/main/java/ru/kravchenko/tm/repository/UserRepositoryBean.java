package ru.kravchenko.tm.repository;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.reposiroty.IUserRepository;
import ru.kravchenko.tm.entity.User;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class UserRepositoryBean implements IUserRepository {

    @Nullable
    private Map<String, User> usersBaseDate = new LinkedHashMap<>();

    @Override
    public @Nullable
    User findByLogin(@Nullable final String login) {
        for (final User user : usersBaseDate.values()) {
            if (login.equals(user.getLogin())) return user;
        }
        return null;
    }

    @Override
    public User findByUserId(@NotNull final String userId) {
        return usersBaseDate.get(userId);
    }

    @Override
    public void showAllUsers() {
        System.out.println(findAll());
    }

    @Override
    public void addUser(@Nullable final User user) {
        usersBaseDate.put(user.getId(), user);
    }

    @Override
    public void removeByLogin(@Nullable final String login) {
        usersBaseDate.remove(findByLogin(login).getId());
    }

    @Override
    public void putUser(@NotNull final User user) {
        usersBaseDate.put(user.getId(), user);
    }

    @Override
    public @NotNull
    Collection<User> findAll() {
        return usersBaseDate.values();
    }

}
