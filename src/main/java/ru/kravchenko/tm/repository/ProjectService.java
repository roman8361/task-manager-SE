package ru.kravchenko.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.Project;
import java.util.Collection;
import java.util.Date;

/**
 * @author Roman Kravchenko
 */

public interface ProjectService {

    @NotNull
    Collection<Project> findAll();

    @NotNull
    Project findOne(@Nullable String id);

    void mergeProject();

    void showAllProject();

    void removeById(@Nullable String id);

    void showAllCommand();

    String getIdFromUser();

    void exit();

    void removeAllProject();

    Date addDateBeginProject();

    Date addDateEndProject();

}
