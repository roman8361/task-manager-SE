package ru.kravchenko.tm.repository;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.reposiroty.ITaskRepository;
import ru.kravchenko.tm.entity.Task;
import ru.kravchenko.tm.sort.ComparatorTaskStatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskRepositoryBean implements ITaskRepository {

    @NotNull
    private Map<String, Task> taskRepository = new LinkedHashMap<>();

    @Override
    public @NotNull
    Collection<Task> findAll(@NotNull final String userId) {
        List<Task> result = new ArrayList<>();
        for (final Task task : taskRepository.values()) {
            if (userId.equals(task.getUserId())) result.add(task);
        }
        return result;
    }

    @Override
    public @NotNull
    Task findOneId(@Nullable final String taskId) {
        if (taskId == null || taskId.isEmpty()) return null;
        return taskRepository.get(taskId);
    }

    @Override
    public void showAllTask(@NotNull final String userId) {
        System.out.println("SORT BY ADD TO REPOSITORY");
        for (final Task task : findAll(userId)) System.out.println(task);
    }

    @Override
    public void showAllTask() {
        System.out.println("SHOW ALL TASK");
        for (final Task task : taskRepository.values()) System.out.println(task);
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
    public void addTask(@Nullable final Task task) {
        taskRepository.put(task.getId(), task);
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
