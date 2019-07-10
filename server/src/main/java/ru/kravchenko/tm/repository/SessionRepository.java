package ru.kravchenko.tm.repository;

import org.apache.ibatis.annotations.*;
import ru.kravchenko.tm.entity.Session;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

public interface SessionRepository {

    @Select("SELECT * FROM `session`")
    List<Session> findAll();

    @Select("SELECT id FROM `session`")
    List<String> ids();

    @Select("SELECT * FROM `session` WHERE id = #{id}")
    @Results(@Result(column = "user_id", property = "userId"))
    Session findOne(final String id);

    @Results(@Result(column = "user_id", property = "userId"))
    @Select("SELECT * FROM `session` WHERE user_id = #{userId}")
    Session findOnByUserId(final String userId);

    @Delete("DELETE FROM `session` WHERE id = #{id}")
    void removeById(final String id);

    @Insert("INSERT INTO `session`(`id`, `signature`, `timestamp`, `user_id`) " +
            "VALUES (#{id}, #{signature}, #{timestamp}, #{userId})")
    void insert(final Session session);

    @Delete("DELETE FROM `session`")
    void clear();

}
