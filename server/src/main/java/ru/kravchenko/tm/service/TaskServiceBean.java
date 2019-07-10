package ru.kravchenko.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ITaskService;
import ru.kravchenko.tm.entity.Task;

/**
 * @author Roman Kravchenko
 */

public class TaskServiceBean implements ITaskService {

    @NotNull
    private final IServiceLocator serviceLocator;

    public TaskServiceBean(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public void mergeTask(@Nullable final String projectId,
                          @Nullable final String taskName,
                          @Nullable final String taskDescription,
                          @Nullable final String userId) {
        final @NotNull Task task = new Task();
        task.setName(taskName);
        task.setDescription(taskDescription);
        task.setProjectId(projectId);
        task.setUserId(userId);
        serviceLocator.getTaskRepository().addTask(task);
    }

    @Override
    public void updateTask(@Nullable final String taskId,
                           @Nullable final String taskName,
                           @Nullable final String taskDescription) {
        @NotNull final Task task = serviceLocator.getTaskRepository().findById(taskId);
        task.setName(taskName);
        task.setDescription(taskDescription);
        serviceLocator.getTaskRepository().removeById(taskId);
        serviceLocator.getTaskRepository().addTask(task);
        System.out.println("Task is update to project");
    }

}
