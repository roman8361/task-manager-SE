package ru.kravchenko.tm.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kravchenko.tm.model.entity.User;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByLogin(final String login);

    @Query("SELECT login FROM User")
    List<String> loginList();

    @Query("SELECT id FROM User")
    List<String> findByAllId();

}
