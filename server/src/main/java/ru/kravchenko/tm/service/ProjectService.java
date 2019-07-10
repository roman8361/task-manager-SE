package ru.kravchenko.tm.service;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import ru.kravchenko.tm.api.repository.old.IProjectRepository;
import ru.kravchenko.tm.api.repository.old.IUserRepository;
import ru.kravchenko.tm.api.service.IProjectService;
import ru.kravchenko.tm.model.dto.ProjectDTO;
import ru.kravchenko.tm.model.dto.SessionDTO;
import ru.kravchenko.tm.model.entity.Project;
import ru.kravchenko.tm.model.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@ApplicationScoped
public class ProjectService implements IProjectService{

    @Inject
    @NotNull
    private IProjectRepository projectRepository;

    @Inject
    @NotNull
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
        @NotNull final User user = userRepository.findById(sessionDTO.getUserId());
        project.setUser(user);  //   setUserId(session.getUserId());
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
        @NotNull final User user = userRepository.findById(sessionDTO.getUserId());
        project.setUser(user);
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
