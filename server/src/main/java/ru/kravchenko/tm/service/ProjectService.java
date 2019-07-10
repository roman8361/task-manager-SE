package ru.kravchenko.tm.service;

import com.sun.istack.internal.Nullable;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.service.IProjectService;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.exception.AccessForbiddenException;
import ru.kravchenko.tm.repository.ProjectRepository;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

public class ProjectService extends AbstractService implements IProjectService {

    private final ProjectRepository projectRepository;

    @NotNull
    private final IServiceLocator serviceLocator;

    public ProjectService(@NotNull final IServiceLocator serviceLocator) throws IOException {
        projectRepository = sqlSession.getMapper(ProjectRepository.class);
        this.serviceLocator = serviceLocator;
    }

    public void insert(@Nullable final Project project) {
        try {
            projectRepository.insert(project);
            commit();
        } catch (Exception e) {
            roolback();
            e.printStackTrace();
        }
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public List<String> ids() {
        return projectRepository.ids();
    }

    public Project findById(@Nullable final String id) {
        if (id == null || id.isEmpty()) return null;
        return projectRepository.findOne(id);
    }

    public void removeById(@Nullable final String id) {
        if (id == null || id.isEmpty()) return;
        try {
            projectRepository.removeById(id);
            commit();
        } catch (Exception e) {
            roolback();
            e.printStackTrace();
        }
    }

    public void clear() {
        projectRepository.clear();
    }

    public void commit() {
        sqlSession.commit();
    }

    public void roolback() {
        sqlSession.rollback();
    }

    public List<Project> findAllProjectByUserId(@Nullable final String userId) {
        return projectRepository.findAllProjectByUserId(userId);
    }

    public void removeAllProjectByUserId(@Nullable final String userId) {
        try {
            projectRepository.removeAllProjectByUserId(userId);
            commit();
        } catch (Exception e) {
            roolback();
            e.printStackTrace();
        }
    }

    @Override
    public void createProject(@NotNull final Session session,
                              @NotNull final String nameProject,
                              @NotNull final String descriptionProject) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        @NotNull final Project project = new Project();
        project.setDescription(descriptionProject);
        project.setName(nameProject);
        project.setDateBegin(new Date());
        project.setDateEnd(new Date());
        project.setUserId(session.getUserId());
        insert(project);
        System.out.println("Project add to repository");
    }

    @Override
    public void updateProject(@NotNull final String projectId,
                              @NotNull final String newProjectName,
                              @NotNull final String newDescription,
                              @NotNull final Session session) {
        if (projectId == null || projectId.isEmpty()) return;
        if (!existProject(projectId)) return;
        final @NotNull Project project = new Project();
        project.setName(newProjectName);
        project.setUserId(session.getUserId());
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
