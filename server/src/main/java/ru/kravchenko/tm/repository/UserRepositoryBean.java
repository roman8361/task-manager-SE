package ru.kravchenko.tm.repository;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.reposiroty.IUserRepository;
import ru.kravchenko.tm.api.service.IConnectionService;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.config.FieldConst;
import ru.kravchenko.tm.entity.User;

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
public class UserRepositoryBean implements IUserRepository {

    @NotNull
    private final IServiceLocator serviceLocator;

    public UserRepositoryBean(@NotNull IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public @NotNull
    List<User> findAll() throws Exception { //OK
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        final Statement statement = serviceLocator.getConnectionService().createStatment();
        final String query = "SELECT * FROM `user`";
        final ResultSet resultSet = statement.executeQuery(query);
        final List<User> result = new ArrayList<>();
        while (resultSet.next()) result.add(fetch(resultSet));
        statement.close();
        connectionService.connect();
        return result;
    }

    @Override
    public void removeAllUsers() throws Exception { // OK
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        final String query = "DELETE FROM `user`";
        final PreparedStatement statement = serviceLocator.getConnectionService().createPreparedStatment(query);
        statement.execute();
        connectionService.disconnect();
    }

    private User fetch(final ResultSet row) throws SQLException { //OK
        if (row == null) return null;
        final User user = new User();
        user.setId(row.getString(FieldConst.ID));
        user.setPasswordHash(row.getString(FieldConst.PASSWORD_HASH));
        user.setLogin(row.getString(FieldConst.LOGIN));
     //   user.setRole(row.getString(FieldConst.ROLE)); TODO
        return user;
    }

    @Override
    @SneakyThrows
    public User findByUserId(@NotNull final String userId) { //OK
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        if (userId == null || userId.isEmpty()) return null;
        final String query = "SELECT * FROM `user` WHERE `id` = ?";
        final PreparedStatement statement = connectionService.createPreparedStatment(query);
        statement.setString(1, userId);
        final ResultSet resultSet = statement.executeQuery();
        final boolean hashNext = resultSet.next();
        if (!hashNext) return null;
        return fetch(resultSet);
    }

    @Override
    @SneakyThrows
    public void showAllUsers() {
        System.out.println("SHOW ALL USER");
        for (User user: findAll()) System.out.println(user);
    }

    @Override
    @SneakyThrows
    public void addUser(@Nullable final User user){ // OK
        if (user == null) return;
        if (user.getId() == null || user.getId().isEmpty()) return;
        final String query = "INSERT INTO `user`(`id`, `login`, `passwordHash`, `role`)" +
                " VALUES(?, ?, ?, ?)";
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        final PreparedStatement statement = connectionService.createPreparedStatment(query);
        statement.setString(1, user.getId());
        statement.setString(2, user.getLogin());
        statement.setString(3, user.getPasswordHash());
        statement.setString(4, user.getRole().toString());
        statement.execute();
        connectionService.disconnect();
    }

    @Override
    public void removeById(@Nullable final String userId) throws Exception {
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        if (userId == null || userId.isEmpty()) return;
        final String query = "DELETE FROM `user` WHERE `id` = ?";
        final PreparedStatement statement = serviceLocator.getConnectionService().createPreparedStatment(query);
        statement.setString(1, userId);
        statement.execute();
        connectionService.disconnect();
    }

    @Override
    public @Nullable
    @SneakyThrows
    User findByLogin(@Nullable final String login) {
        if (login == null || login.isEmpty()) return null;
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        final String query = "SELECT * FROM `user` WHERE `login` = ?";
        final PreparedStatement statement = connectionService.createPreparedStatment(query);
        statement.setString(1, login);
        final ResultSet resultSet = statement.executeQuery();
        final boolean hashNext = resultSet.next();
        if (!hashNext) return null;
        return fetch(resultSet);
    }

}
