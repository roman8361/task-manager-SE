package ru.kravchenko.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.reposiroty.ITaskRepository;
import ru.kravchenko.tm.entity.Task;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

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
        System.out.println(findAll());
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
    public void addTask(@Nullable final String id, final Task task) {
        taskRepository.put(id, task);
    }


}
