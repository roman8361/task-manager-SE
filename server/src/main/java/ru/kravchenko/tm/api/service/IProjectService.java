package ru.kravchenko.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.exception.AccessForbiddenException;

import java.util.List;

/**
 * @author Roman Kravchenko
 */


public interface IProjectService {

    List<Project> findAll();

    List<String> ids();

    Project findById(String id);

    List<Project> findAllProjectByUserId(String userId);

    void removeById(String id);

    void removeAllProjectByUserId(String userId);

    void insert(Project project);

    void clear();

    public void commit();

    public void roolback();

    public void createProject(@NotNull final Session session,
                              @NotNull final String nameProject,
                              @NotNull final String descriptionProject) throws AccessForbiddenException;

    public void updateProject(@NotNull final String projectId,
                              @NotNull final String newProjectName,
                              @NotNull final String newDescription,
                              @NotNull final Session session);

}
