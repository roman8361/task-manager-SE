package ru.kravchenko.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.tm.api.repository.IUserRepository;
import ru.kravchenko.tm.api.repository.UserRepository;
import ru.kravchenko.tm.model.entity.User;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Service
public class UserRepositoryDAO implements IUserRepository {

    @NotNull
    @Autowired
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
        return userRepository.findById(id).get();
    }

    @Override
    public User findByLogin(@NotNull final String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public void removeById(@NotNull final String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void insert(@NotNull final User user) {
        userRepository.save(user);
    }

    @Override
    public void clear() {
        userRepository.deleteAll();
    }

    @Override
    public List<String> loginList() {
        return userRepository.loginList();
    }

}
