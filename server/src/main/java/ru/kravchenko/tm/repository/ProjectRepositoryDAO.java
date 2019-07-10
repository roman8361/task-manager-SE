package ru.kravchenko.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kravchenko.tm.api.repository.IProjectRepository;
import ru.kravchenko.tm.api.repository.ProjectRepository;
import ru.kravchenko.tm.api.repository.UserRepository;
import ru.kravchenko.tm.model.entity.Project;
import ru.kravchenko.tm.model.entity.User;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Service
@Transactional
public class ProjectRepositoryDAO implements IProjectRepository {

    @NotNull
    @Autowired
    private ProjectRepository projectRepository;

    @NotNull
    @Autowired
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
        return projectRepository.findById(id).get();
    }

    @Override
    public List<Project> findAllProjectByUserId(@NotNull final String userId) {
        final User user = userRepository.findById(userId).get();
        return projectRepository.findByUser(user);
    }

    @Override
    public void removeById(@NotNull final String id) {
        projectRepository.deleteById(id);
    }

    @Override
    public void removeAllProjectByUserId(@NotNull final String userId) {
        final User user = userRepository.findById(userId).get();
        final List<Project> userProjectsList = projectRepository.findByUser(user);
        for (Project p : userProjectsList) projectRepository.deleteById(p.getId());
    }

    @Override
    public void insert(@NotNull final Project project) {
        projectRepository.save(project);
    }

    @Override
    public void clear() {
        projectRepository.deleteAll();
    }

}
