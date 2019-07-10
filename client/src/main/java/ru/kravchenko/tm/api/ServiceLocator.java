package ru.kravchenko.tm.api;

/**
 * @author Roman Kravchenko
 */

public interface ServiceLocator {

    void registry(final Object endpoint);

    void initEndpoint();

}
