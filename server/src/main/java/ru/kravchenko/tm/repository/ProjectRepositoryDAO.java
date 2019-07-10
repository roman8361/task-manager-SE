package ru.kravchenko.tm.repository;

import lombok.NoArgsConstructor;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.repository.ProjectRepository;
import ru.kravchenko.tm.api.repository.UserRepository;
import ru.kravchenko.tm.api.repository.old.IProjectRepository;
import ru.kravchenko.tm.model.entity.Project;
import ru.kravchenko.tm.model.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Transactional
@ApplicationScoped
@NoArgsConstructor
public class ProjectRepositoryDAO implements IProjectRepository {

    @Inject
    @NotNull
    private ProjectRepository projectRepository;

    @Inject
    @NotNull
    private UserRepository userRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public List<String> ids() {
        return projectRepository.findAllId();
    }

    @Override
    public Project findById(@NotNull final String id) {
        return projectRepository.findBy(id);
    }

    @Override
    public List<Project> findAllProjectByUserId(@NotNull final String userId) {
        final User user = userRepository.findBy(userId);
        return projectRepository.findByUser(user);
    }

    @Override
    public void removeById(@NotNull final String id) {
        projectRepository.removeById(id);
    }

    @Override
    public void removeAllProjectByUserId(@NotNull final String userId) {
        final User user = userRepository.findBy(userId);
        final List<Project> userProjectsList = projectRepository.findByUser(user);
        for (Project p: userProjectsList) projectRepository.removeById(p.getId());
    }

    @Override
    public void insert(@NotNull final Project project) {
        projectRepository.persist(project);
    }

    @Override
    public void clear() { projectRepository.removeAll(); }

}
