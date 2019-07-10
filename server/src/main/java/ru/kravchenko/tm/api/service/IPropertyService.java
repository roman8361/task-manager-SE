package ru.kravchenko.tm.api.service;

import org.springframework.stereotype.Service;

/**
 * @author Roman Kravchenko
 */

@Service
public interface IPropertyService {

    void init();

    String getJdbcPassword();

    String getJdbcUser();

    String getJdbcURL();

    String getJdbcDriver();

    String getDialect();

    String getShowSQL();

    String getHBM2DDL_AUTO();

    String getServerHost();

    String getServerPort();

}
