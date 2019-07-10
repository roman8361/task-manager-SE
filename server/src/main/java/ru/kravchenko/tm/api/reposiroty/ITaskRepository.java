package ru.kravchenko.tm.api.reposiroty;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.Task;

import java.util.Collection;

/**
 * @author Roman Kravchenko
 */

public interface ITaskRepository {

    @NotNull
    Collection<Task> findAll(@NotNull final String userId);

    @NotNull
    Task findOneId(@Nullable final String taskId);

    void showAllTask(@NotNull final String userId);

    void showAllTask();

    void removeById(@Nullable final String id);

    void removeAllTask();

    void addTask(@Nullable final Task task);

    public void sortByStatus();

    boolean existTask(@Nullable final String taskId);

}
