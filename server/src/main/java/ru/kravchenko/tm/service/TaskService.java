package ru.kravchenko.tm.service;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.repository.IProjectRepository;
import ru.kravchenko.tm.api.repository.ITaskRepository;
import ru.kravchenko.tm.api.repository.IUserRepository;
import ru.kravchenko.tm.api.service.ITaskService;
import ru.kravchenko.tm.model.dto.TaskDTO;
import ru.kravchenko.tm.model.entity.Project;
import ru.kravchenko.tm.model.entity.Task;
import ru.kravchenko.tm.model.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@ApplicationScoped
public class TaskService implements ITaskService {

    @Inject
    @NotNull
    private ITaskRepository taskRepository;

    @Inject
    @NotNull
    private IProjectRepository projectRepository;

    @NotNull
    @Inject
    private IUserRepository userRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public List<String> ids() {
        return taskRepository.ids();
    }

    public TaskDTO findById(@Nullable final String id) {
        return taskRepository.findById(id).getDTO();
    }

    public List<TaskDTO> findAllTaskByUserId(@Nullable final String userId) {
        List<TaskDTO> result = new ArrayList<>();
        for (Task t : taskRepository.findAllTaskByUserId(userId)) result.add(t.getDTO());
        return result;
    }

    public void removeById(@Nullable final String id) {
        taskRepository.removeById(id);
    }

    public void removeAllTaskByUserId(@Nullable final String userId) {
        taskRepository.removeAllTaskByUserId(userId);
    }

    public void insert(@Nullable final Task task) {
        taskRepository.insert(task);
    }

    public void clear() {
        taskRepository.clear();
    }

    public void mergeTask(@Nullable final String projectId,
                          @Nullable final String taskName,
                          @Nullable final String taskDescription,
                          @Nullable final String userId) {
        final @NotNull Task task = new Task();
        task.setName(taskName);
        task.setDescription(taskDescription);
        @NotNull final Project project = projectRepository.findById(projectId);
        task.setProject(project);
        @NotNull final User user = userRepository.findById(userId);
        task.setUser(user);
        insert(task);
    }

    @Override
    public void updateTask(@Nullable final String taskId,
                           @Nullable final String taskName,
                           @Nullable final String taskDescription) {
        @NotNull final TaskDTO taskDTO = findById(taskId);
        taskDTO.setName(taskName);
        taskDTO.setDescription(taskDescription);
        removeById(taskId);
        insert(convertDTOtoTask(taskDTO));
        System.out.println("Task is update to project");
    }

    private Task convertDTOtoTask(@Nullable final TaskDTO taskDTO) {
        final Task task = new Task();
        task.setId(taskDTO.getId());
        task.setDateBegin(taskDTO.getDateBegin());
        task.setDateEnd(taskDTO.getDateEnd());
        task.setDescription(taskDTO.getDescription());
        task.setName(taskDTO.getName());
        task.setUser(userRepository.findById(taskDTO.getUserId()));
        return task;
    }

}
