package ru.kravchenko.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.exception.AccessForbiddenException;

import java.util.Date;

/**
 * @author Roman Kravchenko
 */

public interface IProjectService {

    void createProject(@NotNull final Session session,
                       @NotNull final String projectName,
                       @NotNull final String projectDescription) throws AccessForbiddenException;

    void exit();

    Date addDateBeginProject();

    Date addDateEndProject();

    void updateProject(@NotNull final String projectId,
                       @NotNull final String newProjectName,
                       @NotNull final String newDescription,
                       @NotNull final Session session);

    public void updateStatusProject(@Nullable final String projectId,
                                    @NotNull final String projectStatus);


}
