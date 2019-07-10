package ru.kravchenko.tm.repository;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.reposiroty.IProjectRepository;
import ru.kravchenko.tm.entity.Project;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class ProjectRepositoryBean implements IProjectRepository {

    @Nullable
    private final Map<String, Project> projectRepository = new LinkedHashMap<>();

    @Override
    public @Nullable Collection<Project> findAll() {
        return projectRepository.values();
    }

    @Override
    public void addProject(@Nullable final String projectId, @Nullable final Project project) {
        projectRepository.put(projectId, project);
    }

    @Override
    public @Nullable Project findOne(@Nullable final String id) {
        if (id == null || id.isEmpty()) return null;
        return projectRepository.get(id);
    }

    @Override
    public void showAllProject() { System.out.println(findAll()); }

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

    public boolean existKeys (final @NotNull String projectId) {
        return projectRepository.containsKey(projectId);
    }

}
