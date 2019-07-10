package ru.kravchenko.tm.service;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.service.IProjectService;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.exception.AccessForbiddenException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Roman Kravchenko
 */

public class ProjectServiceBean implements IProjectService {

    @NotNull
    private final IServiceLocator serviceLocator;

    public ProjectServiceBean(@NotNull final IServiceLocator serviceLocator){
        this.serviceLocator = serviceLocator;
    }

    @Override
    public void createProject(@NotNull final Session session,
                              @NotNull final String nameProject,
                              @NotNull final String descriptionProject) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        @NotNull final Project project = new Project(nameProject);
        project.setDescription(descriptionProject);
        project.setDateBegin(new Date());
        project.setDateEnd(new Date());
        project.setUserId(session.getUserId());
        serviceLocator.getProjectRepository().addProject(project);
        System.out.println("Project add to repository");
    }

    @Override
    public void exit() {
        System.out.println("Come back later...");
        System.exit(0);
    }

    @Override
    @SneakyThrows
    public Date addDateBeginProject() {
        System.out.println("Please enter date begin project: (dd.MM.yyyy)");
        @NotNull final String dateBegin = serviceLocator.getTerminalService().nextLine();
        @NotNull final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        @NotNull final Date newDate = simpleDateFormat.parse(dateBegin);
        return newDate;
    }

    @Override
    @SneakyThrows
    public Date addDateEndProject() {
        System.out.println("Please enter date end project: (dd.MM.yyyy)");
        @NotNull final String dateEnd = serviceLocator.getTerminalService().nextLine();
        @NotNull final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        @NotNull final Date endDate = simpleDateFormat.parse(dateEnd);
        return endDate;
    }

    @Override
    public void updateProject(@NotNull final String projectId,
                              @NotNull final String newProjectName,
                              @NotNull final String newDescription,
                              @NotNull final Session session) {
        if (projectId == null || projectId.isEmpty()) return;
        if (!serviceLocator.getProjectRepository().existProject(projectId)) return;
        final @NotNull Project project = new Project(newProjectName);
        project.setUserId(session.getUserId());
        project.setId(projectId);
        project.setDescription(newDescription);
        project.setDateBegin(new Date());
        project.setDateEnd(new Date());
        serviceLocator.getProjectRepository().removeById(projectId);
        serviceLocator.getProjectRepository().addProject(project);
        System.out.println("Project id: " + projectId + "  update");
    }

    @Override
    public void updateStatusProject(@Nullable final String projectId, @NotNull final String projectStatus) {
        if (projectId == null || projectId.isEmpty()) return;
        @NotNull final Project project = serviceLocator.getProjectRepository().findById(projectId);
        project.setStatus(projectStatus);
        serviceLocator.getProjectRepository().addProject(project);
        System.out.println("Project status update");
    }

}
