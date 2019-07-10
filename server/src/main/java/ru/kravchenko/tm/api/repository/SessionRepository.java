package ru.kravchenko.tm.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kravchenko.tm.model.entity.Session;
import ru.kravchenko.tm.model.entity.User;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Repository
public interface SessionRepository extends JpaRepository<Session, String> {

    @Transactional
    void removeById(final String id);

    @Query("SELECT id FROM Session")
    List<String> findAllId();

    List<Session> findByUser(final User user);

}
