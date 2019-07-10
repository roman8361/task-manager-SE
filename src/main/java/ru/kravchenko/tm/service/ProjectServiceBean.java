package ru.kravchenko.tm.service;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.service.IProjectService;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.User;
import ru.kravchenko.tm.repository.ProjectRepositoryBean;
import ru.kravchenko.tm.repository.UserRepositoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

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
    }

    @Override
    public @NotNull void createProject(@Nullable final String nameProject, @Nullable final String descriptionProject) {
        final @NotNull Project project = new Project(nameProject);
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
        final @NotNull String dateBegin = terminalService.nextLine();
        final @NotNull SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        final @NotNull Date newDate = simpleDateFormat.parse(dateBegin);
        return newDate;
    }

    @Override
    @SneakyThrows
    public Date addDateEndProject() {
        System.out.println("Please enter date end project: (dd.MM.yyyy)");
        final @NotNull String dateEnd = terminalService.nextLine();
        final @NotNull SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        final @NotNull Date endDate = simpleDateFormat.parse(dateEnd);
        return endDate;
    }

    @Override
    public void updateProject(@Nullable final String projectId,
                              @Nullable final String newProjectName,
                              @Nullable final String newDescription) {
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
        System.out.println("project-remove: Remove selected project by id.");
        System.out.println("task-clear: Remove all tasks.");
        System.out.println("task-create: Create new task.");
        System.out.println("task-list: Show all tasks.");
        System.out.println("task-update: Update task by id.");
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
