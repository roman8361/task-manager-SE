package ru.kravchenko.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.repository.IProjectRepository;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.model.entity.Project;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

public class ProjectRepository implements IProjectRepository {

    @NotNull
    private IServiceLocator serviceLocator;

    public ProjectRepository(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public List<Project> findAll() {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        List<Project> projects = em.createQuery("SELECT e FROM Project e", Project.class).getResultList();
        em.close();
        return projects;
    }

    @Override
    public List<String> ids() {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        @Nullable final List<String> project = em.createQuery("SELECT id FROM Project e", String.class).getResultList();
        em.close();
        return project;
    }

    @Override
    public Project findById(@NotNull final String id) {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        @NotNull final Project project = em.find(Project.class, id);
        em.close();
        return project;
    }

    @Override
    public List<Project> findAllProjectByUserId(@NotNull final String userId) {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        @Nullable final List<Project> projects = em.createQuery("SELECT e FROM Project e WHERE e.user.id =:userId", Project.class)
                .setParameter("userId", userId)
                .getResultList();
        return projects;
    }

    @Override
    public void removeById(@NotNull final String id) {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        @NotNull final Project project = em.find(Project.class, id);
        em.remove(project);
        em.getTransaction().commit();
    }

    @Override
    public void removeAllProjectByUserId(@NotNull final String userId) {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        @NotNull final List<Project> projects = em.createQuery("SELECT e FROM Project e WHERE e.user.id =:userId", Project.class)
                .setParameter("userId", userId)
                .getResultList();
        for (Project p : projects) em.remove(p);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void insert(@NotNull final Project project) {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        em.persist(project);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void clear() {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        @NotNull final List<Project> projects = em.createQuery("SELECT e FROM Project e", Project.class).getResultList();
        for (Project p : projects) em.remove(p);
        em.getTransaction().commit();
        em.close();
    }

}
