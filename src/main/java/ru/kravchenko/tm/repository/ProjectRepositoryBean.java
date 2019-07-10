package ru.kravchenko.tm.repository;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.reposiroty.IProjectRepository;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.sort.ComparatorProjectDateBegin;
import ru.kravchenko.tm.sort.ComparatorProjectDateEnd;
import ru.kravchenko.tm.sort.ComparatorProjectStatus;

import java.util.*;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class ProjectRepositoryBean implements IProjectRepository {

    @Nullable
    private final Map<String, Project> projectRepository = new LinkedHashMap<>();

    @Override
    @Nullable
    public Collection<Project> findAll() {
        return projectRepository.values();
    }

    @Override
    public void addProject(@Nullable final String projectId, @Nullable final Project project) {
        projectRepository.put(projectId, project);
    }

    @Override
    @Nullable
    public Project findOne(@Nullable final String id) {
        if (id == null || id.isEmpty()) return null;
        return projectRepository.get(id);
    }

    @Override
    public void showAllProject() {
        System.out.println("SORT BY ADD TO REPOSITORY");
        for (final Project project : findAll()) System.out.println(project);
    }

    @Override
    public void sortByDateBegin() {
        System.out.println("SORT BY DATE BEGIN");
        @NotNull final List<Project> list = new ArrayList<>();
        for (Map.Entry<String, Project> map : projectRepository.entrySet()) {
            list.add(map.getValue());
        }
        Collections.sort(list, new ComparatorProjectDateBegin());
        for (Project c : list) System.out.println(c);
    }

    @Override
    public void sortByDateEnd() {
        System.out.println("SORT BY DATE END");
        @NotNull final List<Project> list = new ArrayList<>();
        for (Map.Entry<String, Project> map : projectRepository.entrySet()) {
            list.add(map.getValue());
        }
        Collections.sort(list, new ComparatorProjectDateEnd());
        for (@Nullable final Project project : list) System.out.println(project);
    }

    @Override
    public void sortByStatus() {
        System.out.println("SORT BY STATUS");
        @NotNull final List<Project> list = new ArrayList<>();
        for (Map.Entry<String, Project> map : projectRepository.entrySet()) {
            list.add(map.getValue());
        }
        Collections.sort(list, new ComparatorProjectStatus());
        for (@Nullable final Project project : list) System.out.println(project);
    }

    @Override
    public boolean existProject(@NotNull final String id) {
        if (id == null || id.isEmpty()) return false;
        return projectRepository.containsKey(id);
    }

    @Override
    public void removeById(@Nullable final String projectId) {
        if (projectId == null || projectId.isEmpty()) return;
        if (!projectRepository.containsKey(projectId)) return;
        projectRepository.remove(projectId);
        System.out.println("Project this id: " + projectId + " is remove");
    }

    @Override
    public void removeAllProject() {
        projectRepository.clear();
        System.out.println("All project clear");
    }

    public boolean existKeys (@NotNull final String projectId) {
        return projectRepository.containsKey(projectId);
    }

}
