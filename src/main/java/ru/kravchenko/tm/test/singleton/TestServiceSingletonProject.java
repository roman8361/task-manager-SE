package ru.kravchenko.tm.test.singleton;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Roman Kravchenko
 */

public class TestServiceSingletonProject {

    private static TestServiceSingletonProject instance;

    private TestServiceSingletonProject () {}

    public static synchronized TestServiceSingletonProject getInstance() {
        if (instance == null) {
            instance = new TestServiceSingletonProject();
        }
        return instance;
    }

    @NotNull
    private Map<String, Project> projectMap = new LinkedHashMap<>();


    private @NotNull Collection<Project> findAll() {
        return projectMap.values();
    }


    public Project findById(@Nullable String id) {
        if (id == null || id.isEmpty()) return null;
        return projectMap.get(id);
    }

    public @NotNull void createProject() throws ParseException {
        System.out.println("Please enter project name: ");
        final Scanner scannerName = new Scanner(System.in);
        final String nameProject = scannerName.nextLine();
        final Project project = new Project(nameProject);
        System.out.println("Please enter description for project: ");
        final Scanner scannerDescription = new Scanner(System.in);
        final String description = scannerDescription.nextLine();
        project.setDescription(description);
        project.setDateBering(addDateBegin());
        project.setDateEnd(addDateEnd());
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

    private Date addDateBegin() throws ParseException {
        System.out.println("Please enter date begin project: (dd.MM.yyyy)");
        final Scanner scanner = new Scanner(System.in);
        final String dateBegin = scanner.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date newDate = simpleDateFormat.parse (dateBegin);
        return newDate;
    }

    private Date addDateEnd() throws ParseException {
        System.out.println("Please enter date end project: (dd.MM.yyyy)");
        final Scanner scanner = new Scanner(System.in);
        final String dateEnd = scanner.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date endDate = simpleDateFormat.parse(dateEnd);
        return endDate;
    }

    public void exit() {
        System.exit(0);
    }

    public void removeAllProject() {
        projectMap.clear();
    }

}
