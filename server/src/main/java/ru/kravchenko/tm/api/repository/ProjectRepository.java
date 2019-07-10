package ru.kravchenko.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kravchenko.tm.model.entity.Project;
import ru.kravchenko.tm.model.entity.User;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

    @Query("SELECT id FROM Project")
    List<String> findAllId();

    List<Project> findByUser(@NotNull final User user);

}
