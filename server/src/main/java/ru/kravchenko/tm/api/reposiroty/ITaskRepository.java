package ru.kravchenko.tm.api.reposiroty;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.Task;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

public interface ITaskRepository {

    @NotNull
    List<Task> findAll();

    @NotNull
    Task findById(@Nullable final String taskId);

    void showAllTask();

    void removeById(@Nullable final String id);

    void removeAllTask();

    void addTask(@Nullable final Task task);

    void removeAllTaskByUserId(final String userId);

    List<Task> findAllTaskByUserId(final String userId);


}
