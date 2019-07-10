package ru.kravchenko.tm.api.repository.old;

import ru.kravchenko.tm.model.entity.Project;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

public interface IProjectRepository {

    List<Project> findAll();

    List<String> ids();

    Project findById(final String id);

    List<Project> findAllProjectByUserId(final String userId);

    void removeById(final String id);

    void removeAllProjectByUserId(final String userId);

    void insert(final Project project);

    void clear();

}
