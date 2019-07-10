package ru.kravchenko.tm.api.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Roman Kravchenko
 */
public interface IConnectionService {

    void connect() throws Exception;

    void disconnect() throws SQLException;

    Statement createStatment() throws Exception;

    public PreparedStatement createPreparedStatment(final String sql) throws Exception;

}
