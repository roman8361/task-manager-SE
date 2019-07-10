package ru.kravchenko.tm.repository;

import lombok.NoArgsConstructor;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.repository.TaskRepository;
import ru.kravchenko.tm.api.repository.UserRepository;
import ru.kravchenko.tm.api.repository.old.ITaskRepository;
import ru.kravchenko.tm.model.entity.Task;
import ru.kravchenko.tm.model.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Transactional
@ApplicationScoped
@NoArgsConstructor
public class TaskRepositoryDAO implements ITaskRepository {

    @Inject
    @NotNull
    private TaskRepository taskRepository;

    @Inject
    @NotNull
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
        return taskRepository.findBy(id);
    }

    @Override
    public List<Task> findAllTaskByUserId(@NotNull final String userId) {
        final User user = userRepository.findBy(userId);
        return taskRepository.findByUser(user);
    }

    @Override
    public void removeById(@NotNull final String id) {
        taskRepository.removeById(id);
    }

    @Override
    public void removeAllTaskByUserId(@NotNull final String userId) {
        final User user = userRepository.findBy(userId);
        final List<Task> tasks = taskRepository.findByUser(user);
        for (Task t: tasks) taskRepository.removeById(t.getId());
    }

    @Override
    public void insert(@NotNull final Task task) {
        taskRepository.persist(task);
    }

    @Override
    public void clear() {
        taskRepository.removeAll();
    }

}
