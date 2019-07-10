package ru.kravchenko.tm.api.repository.old;

import ru.kravchenko.tm.model.entity.Session;

import java.util.List;

/**
 * @author Roman Kravchenko
 */
public interface ISessionRepository {

    List<Session> findAll();

    List<String> ids();

    Session findById(final String id);

    Session findOnByUserId(final String userId);

    void removeById(final String id);

    void insert(final Session session);

    void clear();

}
