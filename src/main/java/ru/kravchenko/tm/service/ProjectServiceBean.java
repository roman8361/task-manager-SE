package ru.kravchenko.tm.service;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.service.IProjectService;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.StatusProjectTask;
import ru.kravchenko.tm.entity.User;
import ru.kravchenko.tm.repository.ProjectRepositoryBean;
import ru.kravchenko.tm.repository.UserRepositoryBean;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Roman Kravchenko
 */

public class ProjectServiceBean implements IProjectService {

    @NotNull
    private final IServiceLocator serviceLocator;

    @NotNull
    private final ITerminalService terminalService;

    @NotNull
    private final ProjectRepositoryBean projectRepository;

    @NotNull
    private final UserRepositoryBean userRepositoryBean;

    public ProjectServiceBean(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        terminalService = serviceLocator.getTerminalService();
        userRepositoryBean = (UserRepositoryBean) serviceLocator.getUserRepository();
        projectRepository = (ProjectRepositoryBean) serviceLocator.getProjectRepository();
        initProject();
    }

    private void initProject() {
        final @NotNull Project project = new Project("testProject");
        project.setDescription("setDescription");
        project.setDateBegin(new Date());
        project.setDateEnd(new Date());
        projectRepository.addProject(project.getId(), project);

        final @NotNull Project project2 = new Project("testProject2");
        project2.setDescription("test Project 2");
        project2.setDateBegin(new Date(1));
        project2.setDateEnd(new Date(1));
        project2.setDisplayName(StatusProjectTask.PROCESS);
        projectRepository.addProject(project2.getId(), project2);
    }

    @Override
    public void createProject(@NotNull final String nameProject, @NotNull final String descriptionProject) {
        @NotNull final Project project = new Project(nameProject);
        project.setDescription(descriptionProject);
        project.setDateBegin(addDateBeginProject());
        project.setDateEnd(addDateEndProject());
        projectRepository.addProject(project.getId(), project);
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
        @NotNull final String dateBegin = terminalService.nextLine();
        @NotNull final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        @NotNull final Date newDate = simpleDateFormat.parse(dateBegin);
        return newDate;
    }

    @Override
    @SneakyThrows
    public Date addDateEndProject() {
        System.out.println("Please enter date end project: (dd.MM.yyyy)");
        @NotNull final String dateEnd = terminalService.nextLine();
        @NotNull final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        @NotNull final Date endDate = simpleDateFormat.parse(dateEnd);
        return endDate;
    }

    @Override
    public void updateProject(@NotNull final String projectId,
                              @NotNull final String newProjectName,
                              @NotNull final String newDescription) {
        if (projectId == null || projectId.isEmpty()) return;
        if (!projectRepository.existKeys(projectId)) return;
        final @NotNull Project project = new Project(newProjectName);
        project.setDescription(newDescription);
        project.setDateBegin(addDateBeginProject());
        project.setDateEnd(addDateEndProject());
        projectRepository.addProject(projectId, project);
        System.out.println("Project id: " + projectId + "  update");
    }

    @Override
    public void updateStatusProject(@Nullable final String projectId, @NotNull final StatusProjectTask projectStatus) {
        if (projectId == null || projectId.isEmpty()) return;
        @NotNull final Project project = projectRepository.findOne(projectId);
        project.setDisplayName(projectStatus);
        projectRepository.addProject(projectId, project);
        System.out.println("Project status update");
    }

    @Override
    public void showAllProjectByAdd() {
        LinkedList<Project> linkedList = (LinkedList<Project>) projectRepository.findAll();
        System.out.println(linkedList);
    }

    @Override
    public void searchInName(@NotNull final String text) {
        Collection<Project> list = projectRepository.findAll();
        for (final Project project : list) {
            if (project.getName().contains(text)) {
                System.out.println(project);
            } else {
                System.out.println("Text not found.");
            }
        }
    }

    @Override
    public void searchInDescription(@NotNull final String text) {
        Collection<Project> list = projectRepository.findAll();
        for (final Project project : list) {
            if (project.getDescription().contains(text)) {
                System.out.println(project);
            } else {
                System.out.println("Text not found.");
            }
        }
    }

    @Override
    public void showAllCommand() {
        System.out.println("help: Show all command.");
        System.out.println("user-registry: Registry new user.");
        System.out.println("user-authorization: Login user.");
        System.out.println("user-logout: Logout user.");
        System.out.println("user-change-profile: Change profile user.");
        System.out.println("user-change-password: Change user password.");
        System.out.println("user-all-show: Show all users in Base Date.");
        System.out.println("user-all-show-online: Show all user on line.");
        System.out.println("project-add-user: Add project to user id.");
        System.out.println("project-clear: Remove all projects.");
        System.out.println("project-create: Create new project.");
        System.out.println("project-list: Show all project.");
        System.out.println("project-update: Update project by id.");
        System.out.println("project-update-status: Update project status by id.");
        System.out.println("project-remove: Remove selected project by id.");
        System.out.println("project-search: Search project by name or description.");
        System.out.println("task-clear: Remove all tasks.");
        System.out.println("task-create: Create new task.");
        System.out.println("task-list: Show all tasks.");
        System.out.println("task-update: Update task by id.");
        System.out.println("task-update-status: Update project status by id.");
        System.out.println("exit: Exit");
    }

    @Override
    public void addProjectToUser(@Nullable final String userLogin, @Nullable final String projectId) {
        final @NotNull User user = userRepositoryBean.findByLogin(userLogin, userRepositoryBean.getUsersLoginBase());
        final @NotNull Map<String, User> usersBaseDateThisProject = new LinkedHashMap<>();
        user.setProject(projectRepository.findOne(projectId));
        usersBaseDateThisProject.put(user.getLogin(), user);
        userRepositoryBean.setUsersBaseDate(usersBaseDateThisProject);
        System.out.println("Project add to user: " + userLogin);
    }

}
