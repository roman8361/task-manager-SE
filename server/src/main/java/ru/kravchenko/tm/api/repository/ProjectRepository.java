package ru.kravchenko.tm.api.repository;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Modifying;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.model.entity.Project;
import ru.kravchenko.tm.model.entity.User;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Repository
@Transactional
public interface ProjectRepository extends FullEntityRepository<Project, String> {

    @Modifying
    @Query("SELECT id FROM Project")
    List<String> findAllId();

    @Modifying
    @Query("DELETE FROM Project")
    void removeAll();

    List<Project> findByUser(@NotNull final User user);

    void removeById(final String id);

}
