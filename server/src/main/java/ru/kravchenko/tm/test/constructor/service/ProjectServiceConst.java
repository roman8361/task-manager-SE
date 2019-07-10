package ru.kravchenko.tm.test.constructor.service;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.Project;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Roman Kravchenko
 */
public class ProjectServiceConst {

    @NotNull
    private Map<String, Project> projectMap = new LinkedHashMap<>();

    public @NotNull Collection<Project> findAll() {
        return projectMap.values();
    }

    public  Project findOne(@Nullable String id) {
        if (id == null || id.isEmpty()) return null;
        return projectMap.get(id);
    }

    public @NotNull void mergeProject() {
        System.out.println("Please enter project name: ");
        final Scanner scannerName = new Scanner(System.in);
        final String nameProject = scannerName.nextLine();
        final Project project = new Project(nameProject);
        System.out.println("Please enter description for project: ");
        final Scanner scannerDescription = new Scanner(System.in);
        final String description = scannerDescription.nextLine();
        project.setDescription(description);
        project.setDateBegin(addDateBeginProject());
        project.setDateEnd(addDateEndProject());
        projectMap.put(project.getId(), project);
    }

    public void showAllProject() {
        System.out.println(findAll());
    }

    public @NotNull void removeById(@Nullable String id) {
        if (id == null || id.isEmpty()) return;
        if (!projectMap.containsKey(id)) return;
        projectMap.remove(id);
    }

    public String getIdFromUser() {
        System.out.println("Please enter id project: ");
        final Scanner scanner = new Scanner(System.in);
        final String idProject = scanner.nextLine();
        return idProject;
    }

    public void exit() {
        System.exit(0);
    }

    public void removeAllProject() {
        projectMap.clear();
    }

    @SneakyThrows
    public Date addDateBeginProject() {
        System.out.println("Please enter date begin project: (dd.MM.yyyy)");
        final Scanner scanner = new Scanner(System.in);
        final String dateBegin = scanner.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date newDate = simpleDateFormat.parse(dateBegin);
        return newDate;
    }

    @SneakyThrows
    public Date addDateEndProject() {
        System.out.println("Please enter date end project: (dd.MM.yyyy)");
        final Scanner scanner = new Scanner(System.in);
        final String dateEnd = scanner.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date endDate = simpleDateFormat.parse(dateEnd);
        return endDate;
    }

    public void showAllCommand() {
        System.out.println("help: Show all command.");
        System.out.println("project-clear: Remove all projects.");
        System.out.println("project-create: Create new project.");
        System.out.println("project-list: Show all project.");
        System.out.println("project-remove: Remove selected project by id.");
        System.out.println("task-clear: Remove all tasks.");
        System.out.println("task-create: Create new task.");
        System.out.println("task-list: Show all tasks.");
        System.out.println("task-remove: Remove selected task by id.");
        System.out.println("exit: Exit");
    }

    public void findByIdProject() {
        System.out.println("Please enter id name Project for find from repository: "); // добавить проверку на не корретный ввод
        final Scanner scanner = new Scanner(System.in);
        final String projectId = scanner.nextLine();
        final Project project = findOne(projectId);
        System.out.println(project);
    }

}
