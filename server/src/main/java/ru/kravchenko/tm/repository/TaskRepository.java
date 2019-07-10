package ru.kravchenko.tm.repository;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.repository.ITaskRepository;
import ru.kravchenko.tm.model.entity.Task;
import ru.kravchenko.tm.service.EntityManagerService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@ApplicationScoped
@NoArgsConstructor
public class TaskRepository implements ITaskRepository {

    @Inject
    @NotNull
    private EntityManagerService entityManagerService;

    @Override
    public List<Task> findAll() {
        @NotNull final EntityManager em = entityManagerService.getEntityManager();
        em.getTransaction().begin();
        @Nullable final List<Task> task = em.createQuery("SELECT e FROM Task e", Task.class).getResultList();
        em.close();
        return task;
    }

    @Override
    public List<String> ids() {
        @NotNull final EntityManager em = entityManagerService.getEntityManager();
        em.getTransaction().begin();
        @Nullable final List<String> tasks = em.createQuery("SELECT id FROM Task e", String.class).getResultList();
        em.close();
        return tasks;
    }

    @Override
    public Task findById(@NotNull final String id) {
        @NotNull final EntityManager em = entityManagerService.getEntityManager();
        em.getTransaction().begin();
        @NotNull final Task task = em.find(Task.class, id);
        em.close();
        return task;
    }

    @Override
    public List<Task> findAllTaskByUserId(@NotNull final String userId) {
        @NotNull final EntityManager em = entityManagerService.getEntityManager();
        em.getTransaction().begin();
        @NotNull final List<Task> tasks = em.createQuery("SELECT e FROM Task e WHERE e.user.id =:userId", Task.class)
                .setParameter("userId", userId)
                .getResultList();
        return tasks;
    }

    @Override
    public void removeById(@NotNull final String id) {
        @NotNull final EntityManager em = entityManagerService.getEntityManager();
        em.getTransaction().begin();
        @NotNull final Task task = em.find(Task.class, id);
        em.remove(task);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void removeAllTaskByUserId(@NotNull final String userId) {
        @NotNull final EntityManager em = entityManagerService.getEntityManager();
        em.getTransaction().begin();
        @NotNull final List<Task> tasks = em.createQuery("SELECT e FROM Task e WHERE e.user.id =:userId", Task.class)
                .setParameter("userId", userId)
                .getResultList();
        for (Task t : tasks) em.remove(t);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void insert(@NotNull final Task task) {
        @NotNull final EntityManager em = entityManagerService.getEntityManager();
        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void clear() {
        @NotNull final EntityManager em = entityManagerService.getEntityManager();
        em.getTransaction().begin();
        @Nullable final List<Task> tasks = em.createQuery("SELECT e FROM Task e", Task.class).getResultList();
        for (Task t : tasks) em.remove(t);
        em.getTransaction().commit();
        em.close();
    }

}
