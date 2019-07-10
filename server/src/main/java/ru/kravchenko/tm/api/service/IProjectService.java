package ru.kravchenko.tm.api.service;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.exception.AccessForbiddenException;
import ru.kravchenko.tm.model.dto.ProjectDTO;
import ru.kravchenko.tm.model.dto.SessionDTO;
import ru.kravchenko.tm.model.entity.Project;

import java.util.List;

/**
 * @author Roman Kravchenko
 */


public interface IProjectService {

    List<Project> findAll();

    List<String> ids();

    ProjectDTO findById(String id);

    List<ProjectDTO> findAllProjectByUserId(String userId);

    void removeById(String id);

    void removeAllProjectByUserId(String userId);

    void insert(Project project);

    void clear();

    public void createProject(@NotNull final SessionDTO sessionDTO,
                              @NotNull final String nameProject,
                              @NotNull final String descriptionProject) throws AccessForbiddenException;

    public void updateProject(@NotNull final String projectId,
                              @NotNull final String newProjectName,
                              @NotNull final String newDescription,
                              @NotNull final SessionDTO sessionDTO);

}
