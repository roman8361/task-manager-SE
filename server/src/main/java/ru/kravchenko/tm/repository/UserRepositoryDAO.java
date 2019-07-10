package ru.kravchenko.tm.repository;

import lombok.NoArgsConstructor;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.repository.UserRepository;
import ru.kravchenko.tm.api.repository.old.IUserRepository;
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
public class UserRepositoryDAO implements IUserRepository {

    @Inject
    @NotNull
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<String> ids() {
        return userRepository.findByAllId();
    }

    @Override
    public User findById(@NotNull final String id) {
        return userRepository.findBy(id);
    }

    @Override
    public User findByLogin(@NotNull final String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public void removeById(@NotNull final String id) {
        userRepository.removeById(id);
    }

    @Override
    public void insert(@NotNull final User user) {
        userRepository.persist(user);
    }

    @Override
    public void clear() {
        userRepository.removeAll();
    }

    @Override
    public List<String> loginList() {
        return userRepository.loginList();
    }

}
