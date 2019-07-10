package ru.kravchenko.tm.repository;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.repository.ISessionRepository;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.model.entity.Session;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

public class SessionRepository implements ISessionRepository {

    @NotNull
    private IServiceLocator serviceLocator;

    public SessionRepository(@NotNull IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public List<Session> findAll() {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        @NotNull final List<Session> sessions = em.createQuery("SELECT e FROM Session e", Session.class).getResultList();
        em.close();
        return sessions;
    }

    @Override
    public List<String> ids() {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        @NotNull final List<String> sessions = em.createQuery("SELECT id FROM Session e", String.class).getResultList();
        em.close();
        return sessions;
    }

    @Override
    public Session findOne(@NotNull final String id) {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        @NotNull final Session session = em.find(Session.class, id);
        em.close();
        return session;
    }

    @Override
    public Session findOnByUserId(@NotNull final String userId) { //TODO
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        Session session = em.createQuery("SELECT e FROM Session e WHERE e.user.id =:userId", Session.class)
                .setParameter("userId", userId).getSingleResult();
        return session;
    }

    @Override
    public void removeById(@NotNull final String id) {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        @NotNull final Session session = em.find(Session.class, id);
        em.remove(session);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void insert(@NotNull final Session session) {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        em.persist(session);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void clear() {
        @NotNull final EntityManager em = serviceLocator.getEntityManager().getEntityManager();
        em.getTransaction().begin();
        @NotNull final List<Session> sessions = em.createQuery("SELECT e FROM Session e", Session.class).getResultList();
        for (Session s : sessions) em.remove(s);
        em.getTransaction().commit();
        em.close();
    }

}
