package ru.kravchenko.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.Task;
import ru.kravchenko.tm.repository.TaskService;
import ru.kravchenko.tm.utils.TerminalService;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

public class TaskServiceBean implements TaskService {

    private TerminalService terminalService = new TerminalService();

    @NotNull
    private ProjectServiceBean projectServiceBean;

    public TaskServiceBean(@NotNull ProjectServiceBean projectServiceBean) {
        this.projectServiceBean = projectServiceBean;
    }

    @NotNull
    private Map<String, Task> taskMap = new LinkedHashMap<>();

    @Override
    public @NotNull Collection<Task> findAll() { return taskMap.values(); }

    @Override
    public @NotNull Task findOneId(@Nullable String id) {
        if (id == null || id.isEmpty()) return null;
        return taskMap.get(id);
    }

    public void mergeTask(@Nullable final String projectId,
                          @Nullable final String taskName,
                          @Nullable final String taskDescription) {
        final Project project = projectServiceBean.findOne(projectId);
        final Task task = new Task();
        task.setName(taskName);
        task.setDescription(taskDescription);
        task.setProject(project);
        taskMap.put(task.getId(),task);
        System.out.println("Task is add to project");
    }

    @Override
    public void showAllTask() { System.out.println(findAll()); }

    @Override
    public void removeById(@Nullable String id) {
        if (id == null || id.isEmpty()) return;
        if (!taskMap.containsKey(id)) return;
        taskMap.remove(id);
    }

    @Override
    public String getIdFromUser() {
        System.out.println("Please enter id task: ");
        final String idTask = terminalService.nextLine();
        return idTask;
    }

    @Override
    public void removeAllTask() {
        taskMap.clear();
        System.out.println("All task is remove");
    }

    @Override
    public void updateTask(@Nullable final String taskId,
                           @Nullable final String taskName,
                           @Nullable final String taskDescription) {
        Task task = taskMap.get(taskId);
        task.setName(taskName);
        task.setDescription(taskDescription);
        taskMap.put(task.getId(),task);
        System.out.println("Task is update to project");
    }

}
