package ru.kravchenko.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.Task;
import ru.kravchenko.tm.repository.TaskService;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Roman Kravchenko
 */

public class TaskServiceBean implements TaskService {

    ProjectServiceBean projectServiceBean;

    public TaskServiceBean(ProjectServiceBean projectServiceBean) {
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

    public void mergeTask() {
        System.out.println("Please enter id name Project for Task: "); // добавить проверку на не корретный ввод
        final Scanner scannerIdProject = new Scanner(System.in);
        final String projectId = scannerIdProject.nextLine();
        final Project project = projectServiceBean.findOne(projectId);
        System.out.println("Please enter task name: ");
        final Scanner scannerNameTask = new Scanner(System.in);
        final String nameTask = scannerNameTask.nextLine();
        final Task task = new Task();
        task.setName(nameTask);
        System.out.println("Please enter description for task: ");
        final Scanner scannerDescription = new Scanner(System.in);
        final String description = scannerDescription.nextLine();
        task.setDescription(description);
        task.setProject(project);
        taskMap.put(task.getId(),task);
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
        final Scanner scanner = new Scanner(System.in);
        final String idTask = scanner.nextLine();
        return idTask;
    }

    @Override
    public void removeAllTask() { taskMap.clear(); }

}