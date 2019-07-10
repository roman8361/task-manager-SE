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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.*;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectRepositoryBean implements IProjectRepository, Serializable {

    public ProjectRepositoryBean() {
    }

    @Nullable
    private Map<String, Project> projectRepository = new LinkedHashMap<>();

    @Override
    @Nullable
    public Collection<Project> findAllUserId(@NotNull final String userId) {
        List<Project> result = new ArrayList<>();
        for (final Project project : projectRepository.values()) {
            if (userId.equals(project.getUserId())) result.add(project);
        }
        return result;
    }

    @Override
    public void addProject(@Nullable final Project project) {
        if (project == null) return;
        projectRepository.put(project.getId(), project);
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
        for (final Project project : projectRepository.values()) System.out.println(project);
    }

    @Override
    public void removeAllProject() {
        projectRepository.clear();
    }

    @Override
    public Collection<Project> sortByDateBegin(@NotNull final String userId) {
        System.out.println("SORT BY DATE BEGIN");
        @NotNull final List<Project> result = (List<Project>) findAllUserId(userId);

        Collections.sort(result, new ComparatorProjectDateBegin());
        for (Project c : result) System.out.println(c);
        return result;
    }

    @Override
    public Collection<Project> sortByDateEnd(@NotNull final String userId) {
        System.out.println("SORT BY DATE END");
        @NotNull final List<Project> result = (List<Project>) findAllUserId(userId);

        Collections.sort(result, new ComparatorProjectDateEnd());
        for (Project c : result) System.out.println(c);
        return result;
    }

    @Override
    public Collection<Project> sortByStatus(@NotNull final String userId) {
        System.out.println("SORT BY STATUS");
        @NotNull final List<Project> result = (List<Project>) findAllUserId(userId);
        Collections.sort(result, new ComparatorProjectStatus());
        for (@Nullable final Project project : result) System.out.println(project);
        return result;
    }

    @Override
    public boolean existProject(@NotNull final String id) {
        if (id == null || id.isEmpty()) return false;
        return projectRepository.containsKey(id);
    }

    @Override
    public Map getRepository() {
        return projectRepository;
    }

    @Override
    public void setRepository(@Nullable final Map repository) {
        this.projectRepository = repository;
    }

    @Override
    public void removeById(@Nullable final String projectId) {
        if (projectId == null || projectId.isEmpty()) return;
        if (!projectRepository.containsKey(projectId)) return;
        projectRepository.remove(projectId);
        System.out.println("Project this id: " + projectId + " is remove");
    }

    @Override
    public void removeAllProject(@NotNull final String userId) {
        List<String> list = new ArrayList<>();

        for (final Project project : projectRepository.values()) {
            if (userId.equals(project.getUserId())) list.add(project.getId());
        }

        for (String keyId : list) projectRepository.remove(keyId);
        System.out.println("ALL PROJECT REMOVE");
    }

    public boolean existKeys(@NotNull final String projectId) {
        return projectRepository.containsKey(projectId);
    }

}
