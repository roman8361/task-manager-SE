package ru.kravchenko.tm.api.repository;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Modifying;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.model.entity.Task;
import ru.kravchenko.tm.model.entity.User;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Repository
@Transactional
public interface TaskRepository extends FullEntityRepository<Task, String> {

    @Modifying
    @Query("SELECT id FROM Task")
    List<String> findAllId();

    @Modifying
    @Query("DELETE FROM Task")
    void removeAll();

    void removeById(final String id);

    List<Task> findByUser(@NotNull final User user);

}
