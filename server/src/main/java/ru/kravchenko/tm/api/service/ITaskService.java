package ru.kravchenko.tm.api.service;

import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.exception.AccessForbiddenException;

/**
 * @author Roman Kravchenko
 */

public interface ITaskService {

    void mergeTask(@Nullable final String projectId,
                   @Nullable final String taskName,
                   @Nullable final String taskDescription,
                   @Nullable final String userId) throws AccessForbiddenException;

    void updateTask(@Nullable final String taskId,
                    @Nullable final String taskName,
                    @Nullable final String taskDescription);

}
