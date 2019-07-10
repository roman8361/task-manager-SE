package ru.kravchenko.tm.api.repository.old;

import ru.kravchenko.tm.model.entity.Task;

import java.util.List;

/**
 * @author Roman Kravchenko
 */


public interface ITaskRepository {

    List<Task> findAll();

    List<String> ids();

    Task findById(String id);

    List<Task> findAllTaskByUserId(final String userId);

    void removeById(String id);

    void removeAllTaskByUserId(final String userId);

    void insert(final Task task);

    void clear();

}
