package ru.kravchenko.tm.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import ru.kravchenko.tm.entity.User;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

public interface UserRepository {

    @Select("SELECT * FROM `user`")
    List<User> findAll();

    @Select("SELECT id FROM `user`")
    List<String> ids();

    @Select("SELECT * FROM `user` WHERE id = #{id}")
    User findOne(final String id);

    @Select("SELECT * FROM `user` WHERE login = #{id}")
    User findByLogin(final String login);

    @Delete("DELETE FROM `user` WHERE id = #{id}")
    void removeById(final String id);

    @Insert("INSERT INTO `user`(`id`, `login`, `passwordHash`, `role`, `locked`) " +
            "VALUES (#{id}, #{login}, #{passwordHash}, #{role}, #{locked})")
    void insert(final User user);

    @Delete("DELETE FROM `user`")
    void clear();

    @Select("SELECT login FROM `user`")
    List<String> loginList();

}
