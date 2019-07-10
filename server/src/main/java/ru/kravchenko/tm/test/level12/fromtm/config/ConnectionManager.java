package ru.kravchenko.tm.test.level12.fromtm.config;

import lombok.Getter;
import lombok.Setter;

import java.sql.*;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class ConnectionManager {

    private Config config;

    public ConnectionManager() { this(new DefaultConfig()); }

    public ConnectionManager(final Config config) { this.config = config; }

    private Connection connection;

    public Statement createStatment() throws Exception {
        return  connection.createStatement();
    }

    public PreparedStatement createPreparedStatment(final String sql) throws Exception {
        return connection.prepareStatement(sql);
    }

    public void connect() throws Exception {
        Class.forName(config.getDriveName());
        connection = DriverManager.getConnection(config.toString(), config.getUsername(), config.getPassword());
    }

    public void disconnect() throws SQLException {
        connection.close();
    }

}
