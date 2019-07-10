package ru.kravchenko.tm.service;

import ru.kravchenko.tm.api.service.IEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Roman Kravchenko
 */


public class EntiryManager implements IEntityManager {

    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ENTERPRISE");
        return emf.createEntityManager();
    }

}
