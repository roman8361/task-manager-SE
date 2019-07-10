package ru.kravchenko.tm.api.service;


import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.model.dto.TaskDTO;

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

    TaskDTO findById(@Nullable final String id);

    List<TaskDTO> findAllTaskByUserId(@Nullable final String userId);

    void removeAllTaskByUserId(@Nullable final String userId);

}
