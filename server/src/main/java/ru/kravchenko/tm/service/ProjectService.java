package ru.kravchenko.tm.service;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.tm.api.repository.IProjectRepository;
import ru.kravchenko.tm.api.repository.IUserRepository;
import ru.kravchenko.tm.api.service.IProjectService;
import ru.kravchenko.tm.model.dto.ProjectDTO;
import ru.kravchenko.tm.model.dto.SessionDTO;
import ru.kravchenko.tm.model.entity.Project;
import ru.kravchenko.tm.model.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Service
public class ProjectService implements IProjectService{

    @NotNull
    @Autowired
    private IProjectRepository projectRepository;

    @NotNull
    @Autowired
    private IUserRepository userRepository;

    public void insert(@Nullable final Project project) {
        projectRepository.insert(project);
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public List<String> ids() {
        return projectRepository.ids();
    }

    public ProjectDTO findById(@Nullable final String id) {
        if (id == null || id.isEmpty()) return null;
        return projectRepository.findById(id).getDTO();
    }

    public void removeById(@Nullable final String id) {
        projectRepository.removeById(id);
    }

    public void clear() {
        projectRepository.clear();
    }

    public List<ProjectDTO> findAllProjectByUserId(@Nullable final String userId) {
        List<ProjectDTO> result = new ArrayList<>();
        for (Project p : projectRepository.findAllProjectByUserId(userId)) {
            result.add(p.getDTO());
        }
        return result;
    }

    public void removeAllProjectByUserId(@Nullable final String userId) {
        projectRepository.removeAllProjectByUserId(userId);
    }

    @Override
    public void createProject(@NotNull final SessionDTO sessionDTO,
                              @NotNull final String nameProject,
                              @NotNull final String descriptionProject) {
        @NotNull final Project project = new Project();
        project.setDescription(descriptionProject);
        project.setName(nameProject);
        project.setDateBegin(new Date());
        project.setDateEnd(new Date());
        insert(project);
        System.out.println("Project add to repository");
    }

    @Override
    public void updateProject(@NotNull final String projectId,
                              @NotNull final String newProjectName,
                              @NotNull final String newDescription,
                              @NotNull final SessionDTO sessionDTO) {
        if (projectId == null || projectId.isEmpty()) return;
        if (!existProject(projectId)) return;
        final @NotNull Project project = new Project();
        project.setName(newProjectName);
        project.setId(projectId);
        project.setDescription(newDescription);
        project.setDateBegin(new Date());
        project.setDateEnd(new Date());
        removeById(projectId);
        insert(project);
        System.out.println("Project id: " + projectId + "  update");
    }

    public boolean existProject(@NotNull final String projectId) {
        List<String> projectIds = ids();
        return projectIds.contains(projectId);
    }

}
