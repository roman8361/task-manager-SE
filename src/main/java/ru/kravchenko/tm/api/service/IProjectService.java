package ru.kravchenko.tm.api.service;

import org.jetbrains.annotations.Nullable;
import java.util.Date;

/**
 * @author Roman Kravchenko
 */

public interface IProjectService {

    void createProject(@Nullable final String projectName,
                       @Nullable final String projectDescription);

    void showAllCommand();

    void addProjectToUser(@Nullable final String userId, @Nullable final String projectId);

    void exit();

    Date addDateBeginProject();

    Date addDateEndProject();

    void updateProject(@Nullable final String projectId,
                       @Nullable final String newProjectName,
                       @Nullable final String newDescription);

}
