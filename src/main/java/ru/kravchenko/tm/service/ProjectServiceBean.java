package ru.kravchenko.tm.service;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.User;
import ru.kravchenko.tm.repository.ProjectService;
import ru.kravchenko.tm.utils.TerminalService;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Roman Kravchenko
 */

public class ProjectServiceBean implements ProjectService {

    private TerminalService terminalService = new TerminalService();

    private UserServiceBean userServiceBean;

    public ProjectServiceBean(UserServiceBean userServiceBean) {
        this.userServiceBean = userServiceBean;
        initProject();
    }

    @NotNull
    private Map<String, Project> projectMap = new LinkedHashMap<>();

    private void initProject() {
        final Project project = new Project("testProject");
        project.setDescription("setDescription");
        project.setDateBegin(new Date());
        project.setDateEnd(new Date());
        projectMap.put(project.getId(), project);
    }

    @Override
    public @NotNull Collection<Project> findAll() {
        return projectMap.values();
    }

    @Override
    public  Project findOne(@Nullable String id) {
        if (id == null || id.isEmpty()) return null;
        return projectMap.get(id);
    }

    @Override
    public @NotNull void createProject(@Nullable String nameProject, @Nullable String descriptionProject) {
        final Project project = new Project(nameProject);
        project.setDescription(descriptionProject);
        project.setDateBegin(addDateBeginProject());
        project.setDateEnd(addDateEndProject());
        projectMap.put(project.getId(), project);
        System.out.println("Project add to repository");
    }

    @Override
    public void showAllProject() {
        System.out.println(findAll());
    }

    @Override
    public @NotNull void removeById(@Nullable String projectId) {
        if (projectId == null || projectId.isEmpty()) return;
        if (!projectMap.containsKey(projectId)) return;
        projectMap.remove(projectId);
        System.out.println("Project this id: " + projectId + " is remove");
    }

    @Override
    public void exit() {
        System.out.println("Come back later...");
        System.exit(0);
    }

    @Override
    public void removeAllProject() {
        projectMap.clear();
        System.out.println("All project clear");
    }

    @Override
    @SneakyThrows
    public Date addDateBeginProject() {
        System.out.println("Please enter date begin project: (dd.MM.yyyy)");
        final String dateBegin = terminalService.nextLine();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        final Date newDate = simpleDateFormat.parse(dateBegin);
        return newDate;
    }

    @Override
    @SneakyThrows
    public Date addDateEndProject() {
        System.out.println("Please enter date end project: (dd.MM.yyyy)");
        final String dateEnd = terminalService.nextLine();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        final Date endDate = simpleDateFormat.parse(dateEnd);
        return endDate;
    }

    @Override
    public void updateProject(@Nullable final String projectId,
                              @Nullable final String newProjectName,
                              @Nullable final String newDescription) {
        if (projectId == null || projectId.isEmpty()) return;
        if (!projectMap.containsKey(projectId)) return;
        final Project project = new Project(newProjectName);
        project.setDescription(newDescription);
        project.setDateBegin(addDateBeginProject());
        project.setDateEnd(addDateEndProject());
        projectMap.put(projectId, project);
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
    public void addProjectToUser(@Nullable String userLogin, @Nullable String projectId) {
        final User user = userServiceBean.findByLogin(userLogin);
        final Map<String, User> usersBaseDateThisProject = new LinkedHashMap<>();
        user.setProject(projectMap.get(projectId));
        usersBaseDateThisProject.put(user.getLogin(), user);
        userServiceBean.setUsersBaseDate(usersBaseDateThisProject);
        System.out.println("Project add to user: " + userLogin);
    }

}
