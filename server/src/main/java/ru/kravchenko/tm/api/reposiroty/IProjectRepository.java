package ru.kravchenko.tm.api.reposiroty;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.Project;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

public interface IProjectRepository {

    List<Project> findAllProject() throws Exception;

    @NotNull
    Project findById(@Nullable final String id);

    void showAllProject();

    void removeAllProjectByUserId(final String userId);

    void removeById(@Nullable final String projectId);

    void addProject(@Nullable final Project project);

    List<Project> findAllProjectByUserId(final String userId);

    boolean existProject(@NotNull final String projectId);

}
