package ru.kravchenko.tm.repository;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.reposiroty.ITaskRepository;
import ru.kravchenko.tm.api.service.IConnectionService;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.config.FieldConst;
import ru.kravchenko.tm.entity.Task;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskRepositoryBean implements ITaskRepository {

    @NotNull
    private IServiceLocator serviceLocator;

    public TaskRepositoryBean(@NotNull IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @SneakyThrows
    private Task fetch(final ResultSet row){ // OK
        if (row == null) return null;
        final Task task = new Task();
        task.setId(row.getString(FieldConst.ID));
        task.setDateBegin(row.getDate(FieldConst.DATE_BEGIN));
        task.setDateEnd(row.getDate(FieldConst.DATE_END));
        task.setId(row.getString(FieldConst.ID));
        task.setDescription(row.getString(FieldConst.DESCRIPTION));
        task.setName(row.getString(FieldConst.NAME));
        task.setProjectId(row.getString(FieldConst.PROJECT_ID));
        task.setUserId(row.getString(FieldConst.USER_ID));
        return task;
    }

    @Override
    @SneakyThrows
    public @NotNull List<Task> findAll(){
        final IConnectionService connectionService = serviceLocator.getConnectionService(); //OK
        connectionService.connect();
        final Statement statement = serviceLocator.getConnectionService().createStatment();
        final String query = "SELECT * FROM `task`";
        final ResultSet resultSet = statement.executeQuery(query);
        final List<Task> result = new ArrayList<>();
        while (resultSet.next()) result.add(fetch(resultSet));
        statement.close();
        connectionService.connect();
        return result;
    }

    @Override
    @SneakyThrows
    public void showAllTask() { //OK
        System.out.println("SHOW ALL TASK");
        for (final Task task : findAll()) System.out.println(task);
    }

    @Override
    @SneakyThrows
    public void addTask(@Nullable final Task task) { //OK
        if (task == null) return;
        if (task.getId() == null || task.getId().isEmpty()) return;
        final String query = "INSERT INTO `task`(`id`, `dateBegin`, `dateEnd`, `description`, `name`, `project_id`, `user_id`)" +
                " VALUES(?, ?, ?, ?, ?, ?, ?)";
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        final PreparedStatement statement = connectionService.createPreparedStatment(query);
        statement.setString(1, task.getId());
        statement.setDate(2, (Date) task.getDateBeginSql());
        statement.setDate(3, (Date) task.getDateEndSql());
        statement.setString(4, task.getDescription());
        statement.setString(5, task.getName());
        statement.setString(6, task.getProjectId());
        statement.setString(7, task.getUserId());
        statement.execute();
        connectionService.disconnect();
    }

    @Override
    @SneakyThrows
    public void removeAllTaskByUserId(final String userId) {
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        final String query = "DELETE FROM `task` WHERE `user_id` = ?";
        final PreparedStatement statement = serviceLocator.getConnectionService().createPreparedStatment(query);
        statement.setString(1, userId);
        statement.execute();
        connectionService.disconnect();
    }

    @Override
    @SneakyThrows
    public List<Task> findAllTaskByUserId(final String userId) {
        if (userId == null) return null;
        final String query = "SELECT * FROM `task` WHERE `user_id` = ?";
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        final PreparedStatement statement = connectionService.createPreparedStatment(query);
        statement.setString(1, userId);
        final ResultSet resultSet = statement.executeQuery();
        final List<Task> result = new ArrayList<>();
        while (resultSet.next()) result.add(fetch(resultSet));
        statement.close();
        connectionService.connect();
        return result;
    }

    @Override
    @SneakyThrows
    public @NotNull Task findById(@Nullable final String taskId){ //OK
        if (taskId == null || taskId.isEmpty()) return null;
        final String query = "SELECT * FROM `task` WHERE `id` = ?";
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        final PreparedStatement statement = connectionService.createPreparedStatment(query);
        statement.setString(1, taskId);
        final ResultSet resultSet = statement.executeQuery();
        final boolean hashNext = resultSet.next();
        if (!hashNext) return null;
        return fetch(resultSet);
    }

    @Override
    @SneakyThrows
    public void removeById(@Nullable final String id) { //OK
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        if (id == null || id.isEmpty()) return;
        final String query = "DELETE FROM `task` WHERE `id` = ?";
        final PreparedStatement statement = serviceLocator.getConnectionService().createPreparedStatment(query);
        statement.setString(1, id);
        statement.execute();
        connectionService.disconnect();
    }

    @Override
    @SneakyThrows
    public void removeAllTask() { //OK
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        final String query = "DELETE FROM `task`";
        final PreparedStatement statement = serviceLocator.getConnectionService().createPreparedStatment(query);
        statement.execute();
        connectionService.disconnect();
    }

}
