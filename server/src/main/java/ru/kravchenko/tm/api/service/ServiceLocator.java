package ru.kravchenko.tm.api.service;

/**
 * @author Roman Kravchenko
 */

public interface ServiceLocator {

    void registry(final Object endpoint);

    void initEndpoint();

}
