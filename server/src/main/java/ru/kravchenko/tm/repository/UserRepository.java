package ru.kravchenko.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.repository.IUserRepository;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.model.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

public class UserRepository implements IUserRepository {

    @NotNull
    private IServiceLocator serviceLocator;

    public UserRepository(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public List<User> findAll() {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        List<User> users = em.createQuery("SELECT e FROM User e", User.class).getResultList();
        em.close();
        System.out.println(users);
        return users;
    }

    @Override
    public List<String> ids() {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        List<String> ids = em.createQuery("SELECT id FROM User e", String.class).getResultList();
        em.close();
        return ids;
    }

    @Override
    public User findById(@NotNull final String id) {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        @NotNull final User user = em.find(User.class, id);
        em.close();
        return user;
    }

    @Override
    public User findByLogin(@NotNull final String login) {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        @NotNull final User user = em.createQuery("SELECT e FROM User e WHERE e.login =:login", User.class)
                .setParameter("login", login).getSingleResult();
        em.close();
        return user;
    }

    @Override
    public void removeById(@NotNull final String id) {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        @NotNull final User user = em.find(User.class, id);
        em.remove(user);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void insert(@NotNull final User user) {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void clear() {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        @Nullable final List<User> users = em.createQuery("SELECT e FROM User e", User.class).getResultList();
        for (final User u : users) em.remove(u);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<String> loginList() {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        @Nullable final List<String> loginList = em.createQuery("SELECT login FROM User e", String.class).getResultList();
        em.close();
        return loginList;
    }

}
