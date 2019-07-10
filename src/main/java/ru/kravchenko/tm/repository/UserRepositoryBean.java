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

    @Nullable
    private Map<String, User> usersLoginBase = new LinkedHashMap<>();


    @Override
    public @Nullable User findByLogin(@Nullable final String login, final @Nullable Map map) {
        final User user = (User) map.get(login);
        return user;
    }

    @Override
    public void showAllUsers(final @Nullable Map map) {
        System.out.println(findAll(map));
    }

    @Override
    public void addUser(@Nullable final String userLogin,
                        @Nullable final User user,
                        @Nullable final Map map) {
        map.put(userLogin, user);
    }

    @Override
    public void removeById(@Nullable final String userLogin,
                           @NotNull final Map map) {
        map.remove(userLogin);
    }

    @Override
    public @NotNull Collection<User> findAll(final @Nullable Map map) {
        return map.values();
    }

}
