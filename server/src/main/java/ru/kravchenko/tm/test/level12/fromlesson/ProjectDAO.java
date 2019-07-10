package ru.kravchenko.tm.test.level12.fromlesson;

import lombok.Getter;
import lombok.Setter;
import ru.kravchenko.tm.test.level12.fromlesson.entity.FieldConst;
import ru.kravchenko.tm.test.level12.fromlesson.entity.ProjectDTO;
import ru.kravchenko.tm.test.level12.fromlesson.manager.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class ProjectDAO {

//    private final ConnectionService manager;
//
//    public ProjectDAO() { this(new ConnectionService()); }
//
//
//    public ProjectDAO(ConnectionService manager) {
//        this.manager = manager;
//    }
//
//    private ProjectDTO fetch(final ResultSet row) throws SQLException {
//        if (row == null) return null;
//        final ProjectDTO project = new ProjectDTO();
//        project.setId(row.getString(FieldConst.ID));
//        project.setName(row.getString(FieldConst.NAME));
//        project.setDescription(row.getString(FieldConst.DESCRIPTION));
//        project.setDateBegin(row.getDate(FieldConst.DATE_BEGIN));
//        project.setDateEnd(row.getDate(FieldConst.DATE_END));
//        return project;
//    }
//
//    public List<ProjectDTO> findAllProject() throws Exception {
//        final Statement statement = manager.createStatment();
//        final String query = "SELECT * FROM `project`";
//        final ResultSet resultSet = statement.executeQuery(query);
//        final List<ProjectDTO> result = new ArrayList<>();
//        while (resultSet.next()) result.add(fetch(resultSet));
//        statement.close();
//        return result;
//    }
//
//    public List<String> ids() throws Exception {
//        final Statement statement = manager.createStatment();
//        final String query = "SELECT * FROM `project`";
//        final ResultSet resultSet = statement.executeQuery(query);
//        final List<String> result = new ArrayList<>();
//        while (resultSet.next()) result.add(resultSet.getString(FieldConst.ID));
//        statement.close();
//        return result;
//    }
//
//    public ProjectDTO findById(final String id) throws Exception {
//        if (id == null || id.isEmpty()) return null;
//        final String query = "SELECT * FROM `project` WHERE `id` = ?";
//        final PreparedStatement statement = manager.createPreparedStatment(query);
//        statement.setString(1, id);
//        final ResultSet resultSet = statement.executeQuery();
//        final boolean hashNext = resultSet.next();
//        if (!hashNext) return null;
//        return fetch(resultSet);
//    }
//
//    public void insert(final ProjectDTO project) throws Exception {
//        java.sql.Date sqlDate;
//        if (project == null) return;
//        if (project.getId() == null || project.getId().isEmpty()) return;
//        final String query = "INSERT INTO `project`(`id`, `name`, `description`, `dateBegin`, `dateEnd`)" +
//                " VALUES(?, ?, ?, ?, ?)"; // TO DO
//        final PreparedStatement statement = manager.createPreparedStatment(query);
//        statement.setString(1, project.getId());
//        statement.setString(2, project.getName());
//        statement.setString(3, project.getDescription());
//        statement.setDate(4, (Date) project.getDateBeginSql());
//        statement.setDate(5, (Date) project.getDateEndSql());
//        statement.execute();
//    }
//
//    public void update(final ProjectDTO project) throws Exception {
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
//
//    public void removeById(final String id) throws Exception {
//        if (id == null || id.isEmpty()) return;
//        final String query = "DELETE FROM `project` WHERE `id` = ?";
//        final PreparedStatement statement = manager.createPreparedStatment(query);
//        statement.setString(1, id);
//        statement.execute();
//    }
//
//    public void clear() throws Exception {
//        final String query = "DELETE FROM `project`";
//        final PreparedStatement statement = manager.createPreparedStatment(query);
//        statement.execute();
//    }

}
