package ru.kravchenko.tm.api.repository.old;

import ru.kravchenko.tm.model.entity.User;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

public interface IUserRepository {

    List<User> findAll();

    List<String> ids();

    User findById(final String id);

    User findByLogin(final String login);

    void removeById(final String id);

    void insert(final User user);

    void clear();

    List<String> loginList();

}
