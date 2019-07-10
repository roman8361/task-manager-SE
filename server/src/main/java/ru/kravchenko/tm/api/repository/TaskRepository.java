package ru.kravchenko.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kravchenko.tm.model.entity.Task;
import ru.kravchenko.tm.model.entity.User;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

    @Query("SELECT id FROM Task")
    List<String> findAllId();

    @Transactional
    void removeById(final String id);

    List<Task> findByUser(@NotNull final User user);

}
