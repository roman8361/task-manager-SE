package ru.kravchenko.tm.service;

import com.sun.istack.internal.Nullable;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.service.ITaskService;
import ru.kravchenko.tm.entity.Task;
import ru.kravchenko.tm.repository.TaskRepository;

import java.io.IOException;
import java.util.List;

/**
 * @author Roman Kravchenko
 */
public class TaskService extends AbstractService implements ITaskService {

    private final TaskRepository taskRepository;

    public TaskService() throws IOException {
        taskRepository = sqlSession.getMapper(TaskRepository.class);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public List<String> ids() {
        return taskRepository.ids();
    }

    public Task findById(@Nullable final String id) {
        return taskRepository.findById(id);
    }

    public List<Task> findAllTaskByUserId(@Nullable final String userId) {
        return taskRepository.findAllTaskByUserId(userId);
    }

    public void removeById(@Nullable final String id) {
        try {
            taskRepository.removeById(id);
            commit();
        } catch (Exception e) {
            rollback();
            e.printStackTrace();
        }
    }

    public void removeAllTaskByUserId(@Nullable final String userId) {
        try {
            taskRepository.removeAllTaskByUserId(userId);
            commit();
        } catch (Exception e) {
            rollback();
            e.printStackTrace();
        }
    }

    public void insert(@Nullable final Task task) {
        try {
            taskRepository.insert(task);
            commit();
        } catch (Exception e) {
            rollback();
            e.printStackTrace();
        }
    }

    public void clear() {
        taskRepository.clear();
    }

    public void commit() {
        sqlSession.commit();
    }

    public void rollback() {
        sqlSession.rollback();
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
        insert(task);
    }

    @Override
    public void updateTask(@Nullable final String taskId,
                           @Nullable final String taskName,
                           @Nullable final String taskDescription) {
        @NotNull final Task task = findById(taskId);
        task.setName(taskName);
        task.setDescription(taskDescription);
        removeById(taskId);
        insert(task);
        System.out.println("Task is update to project");
    }

}
