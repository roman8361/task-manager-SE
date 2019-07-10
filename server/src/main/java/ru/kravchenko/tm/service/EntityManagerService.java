package ru.kravchenko.tm.service;

import com.sun.istack.internal.NotNull;
import ru.kravchenko.tm.api.service.IEntityManager;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Roman Kravchenko
 */

//@ApplicationScoped
public class EntityManagerService implements IEntityManager {

    @NotNull
    private static final String UNIX_NAME = "ENTERPRISE";

    @Override
    @Produces
    public EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIX_NAME);
        return emf.createEntityManager();
    }

}
