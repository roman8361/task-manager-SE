package ru.kravchenko.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kravchenko.tm.api.repository.ITaskRepository;
import ru.kravchenko.tm.api.repository.TaskRepository;
import ru.kravchenko.tm.api.repository.UserRepository;
import ru.kravchenko.tm.model.entity.Task;
import ru.kravchenko.tm.model.entity.User;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Service
@Transactional
public class TaskRepositoryDAO implements ITaskRepository {

    @NotNull
    @Autowired
    private TaskRepository taskRepository;

    @NotNull
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<String> ids() {
        return taskRepository.findAllId();
    }

    @Override
    public Task findById(@NotNull final String id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> findAllTaskByUserId(@NotNull final String userId) {
        final User user = userRepository.findById(userId).get();
        return taskRepository.findByUser(user);
    }

    @Override
    public void removeById(@NotNull final String id) {
        taskRepository.removeById(id);
    }

    @Override
    public void removeAllTaskByUserId(@NotNull final String userId) {
        final User user = userRepository.findById(userId).get();
        final List<Task> tasks = taskRepository.findByUser(user);
        for (Task t : tasks) taskRepository.removeById(t.getId());
    }

    @Override
    public void insert(@NotNull final Task task) {
        taskRepository.save(task);
    }

    @Override
    public void clear() {
        taskRepository.deleteAll();
    }

}
