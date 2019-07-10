package ru.kravchenko.tm.api.service;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author Roman Kravchenko
 */

@ApplicationScoped
public interface IPropertyService {

    String getServerHost();

    String getServerPort();

}
