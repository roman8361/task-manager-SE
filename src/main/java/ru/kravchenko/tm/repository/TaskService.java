package ru.kravchenko.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.Task;

import java.util.Collection;

/**
 * @author Roman Kravchenko
 */

public interface TaskService {
    @NotNull
    Collection<Task> findAll();

    @NotNull
    Task findById(@Nullable String id);

    void createTask();

    void showAllTask();

    void removeById(@Nullable String id);

    String getIdFromUser();

    void removeAllTask();
}
