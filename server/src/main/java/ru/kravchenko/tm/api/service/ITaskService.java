package ru.kravchenko.tm.api.service;

import com.sun.istack.internal.Nullable;
import ru.kravchenko.tm.entity.Task;

import java.util.List;

/**
 * @author Roman Kravchenko
 */
public interface ITaskService {

    void mergeTask(@Nullable final String projectId,
                   @Nullable final String taskName,
                   @Nullable final String taskDescription,
                   @Nullable final String userId);

    void updateTask(@Nullable final String taskId,
                    @Nullable final String taskName,
                    @Nullable final String taskDescription);

    void removeById(@Nullable final String id);

    Task findById(@Nullable final String id);

    List<Task> findAllTaskByUserId(@Nullable final String userId);

    void removeAllTaskByUserId(@Nullable final String userId);

}
