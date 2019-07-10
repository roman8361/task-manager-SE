package ru.kravchenko.tm.repository;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.reposiroty.IProjectRepository;
import ru.kravchenko.tm.api.service.IConnectionService;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.config.FieldConst;
import ru.kravchenko.tm.entity.Project;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
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
public class ProjectRepositoryBean implements IProjectRepository, Serializable {

    @NotNull
    private IServiceLocator serviceLocator;

    public ProjectRepositoryBean(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @SneakyThrows
    private Project fetch(final ResultSet row) {
        if (row == null) return null;
        final Project project = new Project();
        project.setId(row.getString(FieldConst.ID));
        project.setName(row.getString(FieldConst.NAME));
        project.setDescription(row.getString(FieldConst.DESCRIPTION));
        project.setDateBegin(row.getDate(FieldConst.DATE_BEGIN));
        project.setDateEnd(row.getDate(FieldConst.DATE_END));
        project.setUserId(row.getString(FieldConst.USER_ID));
        return project;
    }

    @Override
    @SneakyThrows
    public List<Project> findAllProject(){
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        final Statement statement = serviceLocator.getConnectionService().createStatment();
        final String query = "SELECT * FROM `project`";
        final ResultSet resultSet = statement.executeQuery(query);
        final List<Project> result = new ArrayList<>();
        while (resultSet.next()) result.add(fetch(resultSet));
        statement.close();
        connectionService.connect();
        return result;
    }

    @SneakyThrows
    public List<Project> findAllProjectByUserId(final String userId) {
        if (userId == null) return null;
        final String query = "SELECT * FROM `project` WHERE `user_id` = ?";
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        final PreparedStatement statement = connectionService.createPreparedStatment(query);
        statement.setString(1, userId);
        final ResultSet resultSet = statement.executeQuery();
        final List<Project> result = new ArrayList<>();
        while (resultSet.next()) result.add(fetch(resultSet));
        statement.close();
        connectionService.connect();
        return result;
    }

    @Override
    @SneakyThrows
    public void addProject(@Nullable final Project project) {
        if (project == null) return;
        if (project.getId() == null || project.getId().isEmpty()) return;
        final String query = "INSERT INTO `project`(`id`, `name`, `description`, `dateBegin`, `dateEnd`, `user_id`, `status`)" +
                " VALUES(?, ?, ?, ?, ?, ?, ?)";
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        final PreparedStatement statement = connectionService.createPreparedStatment(query);
        statement.setString(1, project.getId());
        statement.setString(2, project.getName());
        statement.setString(3, project.getDescription());
        statement.setDate(4, (Date) project.getDateBeginSql());
        statement.setDate(5, (Date) project.getDateEndSql());
        statement.setString(6, project.getUserId());
        statement.setString(7, project.getStatus());
        statement.execute();
        connectionService.disconnect();
    }

    @Override
    @Nullable
    @SneakyThrows
    public Project findById(@Nullable final String id) {
        if (id == null || id.isEmpty()) return null;
        final String query = "SELECT * FROM `project` WHERE `id` = ?";
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        final PreparedStatement statement = connectionService.createPreparedStatment(query);
        statement.setString(1, id);
        final ResultSet resultSet = statement.executeQuery();
        final boolean hashNext = resultSet.next();
        if (!hashNext) return null;
        return fetch(resultSet);
    }

    @Override
    @SneakyThrows
    public void removeAllProjectByUserId(final String userId){
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        final String query = "DELETE FROM `project` WHERE `user_id` = ?";
        final PreparedStatement statement = serviceLocator.getConnectionService().createPreparedStatment(query);
        statement.setString(1, userId);
        statement.execute();
        connectionService.disconnect();
    }

    @Override
    @SneakyThrows
    public void removeById(@Nullable final String projectId) {
        final IConnectionService connectionService = serviceLocator.getConnectionService();
        connectionService.connect();
        if (projectId == null || projectId.isEmpty()) return;
        final String query = "DELETE FROM `project` WHERE `id` = ?";
        final PreparedStatement statement = serviceLocator.getConnectionService().createPreparedStatment(query);
        statement.setString(1, projectId);
        statement.execute();
        connectionService.disconnect();
    }

    @Override
    @SneakyThrows
    public void showAllProject() {
        System.out.println("SORT BY ADD TO REPOSITORY");
        for (final Project project : findAllProject()) System.out.println(project);
    }

    public boolean existProject(@NotNull final String projectId){
        for (Project project: findAllProject()) {
            if (projectId.equals(project.getId())) return true;
        }
        return false;
    }

}
