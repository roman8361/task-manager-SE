package ru.kravchenko.tm.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.StatusProjectTask;

/**
 * @author Roman Kravchenko
 */

public interface ITaskService {


    void mergeTask(@Nullable final String projectId,
                   @Nullable final String taskName,
                   @Nullable final String taskDescription);

    String getIdFromUser();

    void updateTask(@Nullable final String taskId,
                    @Nullable final String taskName,
                    @Nullable final String taskDescription);

    void updateTaskStatus(@NotNull final String taskId,
                          @NotNull final StatusProjectTask taskStatus);

}
