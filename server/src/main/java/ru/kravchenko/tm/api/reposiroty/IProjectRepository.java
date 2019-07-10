package ru.kravchenko.tm.api.reposiroty;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.Project;

import java.util.Collection;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

public interface IProjectRepository {

    @NotNull
    Collection<Project> findAllUserId(@NotNull final String userId);

    @NotNull
    Project findOne(@Nullable final String id);

    void showAllProject();

    void removeAllProject();

    void removeById(@Nullable final String projectId);

    void removeAllProject(@NotNull final String userId);

    void addProject(@Nullable final Project project);

    Collection<Project> sortByDateBegin(@NotNull final String userId);

    Collection<Project> sortByDateEnd(@NotNull final String userId);

    Collection<Project> sortByStatus(@NotNull final String userId);

    boolean existProject(@NotNull final String id);

    Map getRepository();

    void setRepository(@Nullable final Map map);

}
