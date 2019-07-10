package ru.kravchenko.tm.repository;

import org.apache.ibatis.annotations.*;
import ru.kravchenko.tm.entity.Project;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

public interface ProjectRepository {

    @Select("SELECT * FROM `project`")
    List<Project> findAll();

    @Select("SELECT id FROM `project`")
    List<String> ids();

    @Select("SELECT * FROM `project` WHERE id = #{id}")
    @Results(@Result(column = "user_id", property = "userId"))
    Project findOne(final String id);

    @Select("SELECT * FROM `project` WHERE user_id = #{userId}")
    List<Project> findAllProjectByUserId(final String userId);

    @Delete("DELETE FROM `project` WHERE id = #{id}")
    void removeById(final String id);

    @Delete("DELETE FROM `project` WHERE user_id = #{userId}")
    void removeAllProjectByUserId(final String userId);

    @Insert("INSERT INTO `project`(`id`, `name`, `description`, `dateBegin`, `dateEnd`, `user_id`, `status`) " +
            "VALUES (#{id}, #{name}, #{description}, #{dateBegin}, #{dateEnd}, #{userId}, #{status})")
    void insert(final Project project);

    @Delete("DELETE FROM `project`")
    void clear();

}
