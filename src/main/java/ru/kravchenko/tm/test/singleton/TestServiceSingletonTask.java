package ru.kravchenko.tm.test.singleton;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.Task;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Roman Kravchenko
 */

public class TestServiceSingletonTask {

    private TestServiceSingletonProject singletonProject = TestServiceSingletonProject.getInstance();

    private static TestServiceSingletonTask instance;

    private TestServiceSingletonTask () {}

    public static synchronized TestServiceSingletonTask getInstance() {
        if (instance == null) {
            instance = new TestServiceSingletonTask();
        }
        return instance;
    }

    @NotNull
    private Map<String, Task> taskMap = new LinkedHashMap<>();

    public @NotNull Collection<Task> findAll() { return taskMap.values(); }

    public @NotNull Task findById(@Nullable String id) {
        if (id == null || id.isEmpty()) return null;
        return taskMap.get(id);
    }

    public void createTask() {
        System.out.println("Please enter id name Project for Task: ");
        final Scanner scanner = new Scanner(System.in);
        final String projectId = scanner.nextLine();
        final Project project1 = singletonProject.findById(projectId);
        System.out.println("Please enter task name: ");
        final Scanner sc1 = new Scanner(System.in);
        final String nameTask = sc1.nextLine();
        final Task task = new Task();
        task.setName(nameTask);
        System.out.println("Please enter description for task: ");
        final Scanner sc2 = new Scanner(System.in);
        final String description = sc2.nextLine();
        task.setDescription(description);
        task.setProject(project1);
        taskMap.put(task.getId(), task);
    }

    public void showAllTask() { System.out.println(findAll()); }

    public void removeById(@Nullable String id) {
        if (id == null || id.isEmpty()) return;
        if (!taskMap.containsKey(id)) return;
        taskMap.remove(id);
    }

    public String getIdFromUser() {
        System.out.println("Please enter id task: ");
        final Scanner scanner = new Scanner(System.in);
        final String idTask = scanner.nextLine();
        return idTask;
    }

    public void removeAllTask() { taskMap.clear(); }

}
