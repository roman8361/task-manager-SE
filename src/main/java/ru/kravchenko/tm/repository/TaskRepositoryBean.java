package ru.kravchenko.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.reposiroty.ITaskRepository;
import ru.kravchenko.tm.entity.Task;
import ru.kravchenko.tm.sort.ComparatorTaskStatus;

import java.util.*;

/**
 * @author Roman Kravchenko
 */

public class TaskRepositoryBean implements ITaskRepository {

    @NotNull
    private final Map<String, Task> taskRepository = new LinkedHashMap<>();

    @Override
    public @NotNull Collection<Task> findAll() {
        return taskRepository.values();
    }

    @Override
    public @NotNull Task findOneId(@Nullable final String id) {
        if (id == null || id.isEmpty()) return null;
        return taskRepository.get(id);
    }

    @Override
    public void showAllTask() {
        System.out.println("SORT BY ADD TO REPOSITORY");
        for (final Task task : findAll()) System.out.println(task);
    }

    @Override
    public void removeById(@Nullable final String id) {
        if (id == null || id.isEmpty()) return;
        if (!taskRepository.containsKey(id)) return;
        taskRepository.remove(id);
    }

    @Override
    public void removeAllTask() {
        taskRepository.clear();
        System.out.println("All task is remove");
    }

    @Override
    public void addTask(@Nullable final String id, @Nullable final Task task) {
        taskRepository.put(id, task);
    }

    @Override
    public void sortByStatus() {
        System.out.println("SORT BY STATUS");
        @NotNull final List<Task> list = new ArrayList<>();
        for (Map.Entry<String, Task> map : taskRepository.entrySet()) {
            list.add(map.getValue());
        }
        Collections.sort(list, new ComparatorTaskStatus());
        for (@Nullable final Task task : list) System.out.println(task);
    }

    @Override
    public boolean existTask(@Nullable final String taskId) {
        if (taskId == null || taskId.isEmpty()) return false;
        return taskRepository.containsKey(taskId);
    }

}
