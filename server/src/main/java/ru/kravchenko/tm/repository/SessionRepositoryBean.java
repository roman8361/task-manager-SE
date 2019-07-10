package ru.kravchenko.tm.repository;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.reposiroty.ISessionRepository;
import ru.kravchenko.tm.api.service.IConnectionService;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.config.FieldConst;
import ru.kravchenko.tm.entity.Session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class SessionRepositoryBean implements ISessionRepository {

    @NotNull
    private IServiceLocator serviceLocator;

    public SessionRepositoryBean(@NotNull IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    private Session fetch(final ResultSet row) throws SQLException {
        if (row == null) return null;
        final Session session = new Session();
        session.setId(row.getString(FieldConst.ID));
        session.setUserId(row.getString(FieldConst.USER_ID));
        session.setSignature(row.getString(FieldConst.SIGNATURE));
        session.setTimestamp(row.getTimestamp(FieldConst.TIMESTAMP));
        return session;
    }

    @Override
    @SneakyThrows
    public List<Session> findAll() {
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        final Statement statement = serviceLocator.getConnectionService().createStatment();
        final String query = "SELECT * FROM `session`";
        final ResultSet resultSet = statement.executeQuery(query);
        final List<Session> result = new ArrayList<>();
        while (resultSet.next()) result.add(fetch(resultSet));
        statement.close();
        connectionService.connect();
        return result;
    }

    @Override
    @SneakyThrows
    public void addSession(@NotNull final Session session) { //TODO OK
        if (session == null) return;
        if (session.getId() == null || session.getId().isEmpty()) return;
        final String query = "INSERT INTO `session`(`id`, `signature`, `user_id`)" +
                " VALUES(?, ?, ?)";
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        final PreparedStatement statement = connectionService.createPreparedStatment(query);
        statement.setString(1, session.getId());
        statement.setString(2, session.getSignature());
 //       statement.setDate(3, (Date) session.getTimestampSql());
        statement.setString(3, session.getUserId());
        statement.execute();
        connectionService.disconnect();
    }

    @Override
    @SneakyThrows
    public Session findById(@Nullable final String sessionId) { //OK
        if (sessionId == null || sessionId.isEmpty()) return null;
        final String query = "SELECT * FROM `session` WHERE `id` = ?";
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        final PreparedStatement statement = connectionService.createPreparedStatment(query);
        statement.setString(1, sessionId);
        final ResultSet resultSet = statement.executeQuery();
        final boolean hashNext = resultSet.next();
        if (!hashNext) return null;
        return fetch(resultSet);
    }

    @Override
    @SneakyThrows
    public void removeById(@Nullable final String sessionId) { // OK
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        if (sessionId == null || sessionId.isEmpty()) return;
        final String query = "DELETE FROM `session` WHERE `id` = ?";
        final PreparedStatement statement = serviceLocator.getConnectionService().createPreparedStatment(query);
        statement.setString(1, sessionId);
        statement.execute();
        connectionService.disconnect();
    }

    @Override
    @SneakyThrows
    public void removeAll() { // OK
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        final String query = "DELETE FROM `session`";
        final PreparedStatement statement = serviceLocator.getConnectionService().createPreparedStatment(query);
        statement.execute();
        connectionService.disconnect();
    }

    @Override
    @SneakyThrows
    public void showAllSession() {
    List<Session> list = findAll();
    for (Session session: list) System.out.println(session);
    }

    @Override
    @SneakyThrows
    public boolean exist(@NotNull final String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) return false;
        if (serviceLocator.getSessionRepository().findById(sessionId) == null) return false;
        return true;
    }

    @Override
    @SneakyThrows
    public Session findByUserId(final String userId) {
        if (userId == null || userId.isEmpty()) return null;
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        final String query = "SELECT * FROM `session` WHERE `user_id` = ?";
        final PreparedStatement statement = connectionService.createPreparedStatment(query);
        statement.setString(1, userId);
        final ResultSet resultSet = statement.executeQuery();
        final boolean hashNext = resultSet.next();
        if (!hashNext) return null;
        return fetch(resultSet);
    }

}
