package ru.kravchenko.tm.api.reposiroty;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.Project;
import java.util.Collection;

/**
 * @author Roman Kravchenko
 */

public interface IProjectRepository {

    @NotNull
    Collection<Project> findAll();

    @NotNull
    Project findOne(@Nullable final String id);

    void showAllProject();

    void removeById(@Nullable final String projectId);

    void removeAllProject();

    void addProject(@Nullable final String projectId, @Nullable final Project project);

}
