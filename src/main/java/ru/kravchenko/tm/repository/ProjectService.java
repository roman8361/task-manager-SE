package ru.kravchenko.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.Project;
import java.util.Collection;
import java.util.Date;

/**
 * @author Roman Kravchenko
 */

public interface ProjectService {

    @NotNull
    Collection<Project> findAll();

    @NotNull
    Project findOne(@Nullable String id);

    void createProject(@Nullable String nameProject,
                       @Nullable String descriptionProject);

    void showAllProject();

    void removeById(@Nullable final String projectId);

    void showAllCommand();

    void addProjectToUser(@Nullable String userId, @Nullable String projectId);

   // String getIdFromUser();

    void exit();

    void removeAllProject();

    Date addDateBeginProject();

    Date addDateEndProject();

    void updateProject(@Nullable final String projectId,
                       @Nullable final String newProjectName,
                       @Nullable final String newDescription);

}
