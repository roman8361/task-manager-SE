package ru.kravchenko.tm.repository;

import org.apache.ibatis.annotations.*;
import ru.kravchenko.tm.entity.Task;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

public interface TaskRepository {

    @Select("SELECT * FROM `task`")
    List<Task> findAll();

    @Select("SELECT id FROM `task`")
    List<String> ids();

    @Select("SELECT * FROM `task` WHERE id = #{id}")
    @Results(@Result(column = "user_id", property = "userId"))
    Task findById(String id);

    @Results(@Result(column = "user_id", property = "userId"))
    @Select("SELECT * FROM `task` WHERE user_id = #{userId}")
    List<Task> findAllTaskByUserId(final String userId);

    @Delete("DELETE FROM `task` WHERE id = #{id}")
    void removeById(String id);

    @Delete("DELETE FROM `task` WHERE user_id = #{userId}")
    void removeAllTaskByUserId(final String userId);

    @Insert("INSERT INTO `task`(`id`, `name`, `description`, `project_id`, `user_id`, `dateBegin`, `dateEnd`, `status`) " +
            "VALUES (#{id}, #{name}, #{description}, #{projectId}, #{userId}, #{dateBegin}, #{dateEnd}, #{status})")
    void insert(final Task task);

    @Delete("DELETE FROM `task`")
    void clear();

}
