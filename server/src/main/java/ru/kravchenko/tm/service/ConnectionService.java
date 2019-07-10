package ru.kravchenko.tm.service;

import lombok.Getter;
import lombok.Setter;
import ru.kravchenko.tm.api.service.IConnectionService;
import ru.kravchenko.tm.config.Config;
import ru.kravchenko.tm.config.DefaultConfig;

import java.sql.*;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class ConnectionService implements IConnectionService {

    private Config config;

    public ConnectionService() { this(new DefaultConfig()); }

    public ConnectionService(final Config config) { this.config = config; }

    private Connection connection;


    public void connect() throws Exception {
        Class.forName(config.getDriveName());
        connection = DriverManager.getConnection(config.toString(), config.getUsername(), config.getPassword());
    }

    public void disconnect() throws SQLException {
        connection.close();
    }

    public Statement createStatment() throws Exception {
        return  connection.createStatement();
    }

    public PreparedStatement createPreparedStatment(final String sql) throws Exception {
        return connection.prepareStatement(sql);
    }

}
