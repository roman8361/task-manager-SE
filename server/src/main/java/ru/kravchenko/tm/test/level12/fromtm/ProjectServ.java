package ru.kravchenko.tm.test.level12.fromtm;

import lombok.Getter;
import lombok.Setter;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.test.level12.fromtm.config.ConnectionManager;
import ru.kravchenko.tm.test.level12.fromtm.config.FieldConst;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class ProjectServ {

    private final ConnectionManager manager;

    public ProjectServ() { this(new ConnectionManager()); }


    public ProjectServ(ConnectionManager manager) {
        this.manager = manager;
    }

    private Project fetch(final ResultSet row) throws SQLException {
        if (row == null) return null;
        final Project project = new Project();
        project.setId(row.getString(FieldConst.ID));
        project.setName(row.getString(FieldConst.NAME));
        project.setDescription(row.getString(FieldConst.DESCRIPTION));
        project.setDateBegin(row.getDate(FieldConst.DATE_BEGIN));
        project.setDateEnd(row.getDate(FieldConst.DATE_END));
        return project;
    }

    public List<Project> findAll() throws Exception {
        final Statement statement = manager.createStatment();
        final String query = "SELECT * FROM `project`";
        final ResultSet resultSet = statement.executeQuery(query);
        final List<Project> result = new ArrayList<>();
        while (resultSet.next()) result.add(fetch(resultSet));
        statement.close();
        return result;
    }

    public List<String> ids() throws Exception {
        final Statement statement = manager.createStatment();
        final String query = "SELECT * FROM `project`";
        final ResultSet resultSet = statement.executeQuery(query);
        final List<String> result = new ArrayList<>();
        while (resultSet.next()) result.add(resultSet.getString(FieldConst.ID));
        statement.close();
        return result;
    }

    public Project findOne(final String id) throws Exception {
        if (id == null || id.isEmpty()) return null;
        final String query = "SELECT * FROM `project` WHERE `id` = ?";
        final PreparedStatement statement = manager.createPreparedStatment(query);
        statement.setString(1, FieldConst.ID);
        final ResultSet resultSet = statement.executeQuery();
        final boolean hashNext = resultSet.next();
        if (!hashNext) return null;
        return fetch(resultSet);
    }

    public Project findByName(final String name) throws Exception { // TO DO
        if (name == null || name.isEmpty()) return null;
        final String query = "SELECT * FROM `project` WHERE `name` = ?";
        final PreparedStatement statement = manager.createPreparedStatment(query);
        statement.setString(2, FieldConst.NAME);
        final ResultSet resultSet = statement.executeQuery();
        final boolean hashNext = resultSet.next();
        if (!hashNext) return null;
        return fetch(resultSet);
    }

    public void insert(final Project project) throws Exception {
        if (project == null) return;
        if (project.getId() == null || project.getId().isEmpty()) return;
        final String query = "INSERT INTO `project`(`id`, `name`, `description`, `dateBegin`, `dateEnd`)" +
                " VALUES(?, ?, ?, ?, ?)";
        final PreparedStatement statement = manager.createPreparedStatment(query);
        statement.setString(1, project.getId());
        statement.setString(2, project.getName());
        statement.setString(3, project.getDescription());
        statement.setDate(4, (Date) project.getDateBeginSql());
        statement.setDate(5, (Date) project.getDateEndSql());
        statement.execute();
    }

//    public void update(final Project project) throws Exception {
//        if (project == null) return;
//        if (project.getId() == null || project.getId().isEmpty()) return;
//        final String query = "UPDATE project SET `name` = ?, `description` = ?, `dateBegin` = ?, `dateEnd` = ?"; // TO DO
//        final PreparedStatement statement = manager.createPreparedStatment(query);
//        statement.setString(1, project.getId());
//        statement.setString(2, project.getName());
//        statement.setString(3, project.getDescription());
//        statement.setDate(4, (Date) project.getDateBeginSql());
//        statement.setDate(5, (Date) project.getDateEndSql());
//        statement.execute();
//    }

    public void removeById(final String id) throws Exception {
        if (id == null || id.isEmpty()) return;
        final String query = "DELETE FROM `project` WHERE `id` = ?";
        final PreparedStatement statement = manager.createPreparedStatment(query);
        statement.setString(1, id);
        statement.execute();
    }

    public void clear() throws Exception {
        final String query = "DELETE FROM `project`";
        final PreparedStatement statement = manager.createPreparedStatment(query);
        statement.execute();
    }

}
