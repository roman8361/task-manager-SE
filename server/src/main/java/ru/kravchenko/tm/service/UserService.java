package ru.kravchenko.tm.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kravchenko.tm.api.service.IUserService;
import ru.kravchenko.tm.exception.UserLoginBusyException;
import ru.kravchenko.tm.exception.UserNotFoundException;
import ru.kravchenko.tm.model.entity.Session;
import ru.kravchenko.tm.model.entity.Status;
import ru.kravchenko.tm.model.entity.User;
import ru.kravchenko.tm.repository.UserRepositoryDAO;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Service
public class UserService implements IUserService {

    @NotNull
    @Autowired
    private UserRepositoryDAO userRepository;

    @NotNull
    @Autowired
    private SessionService sessionService;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<String> ids() {
        return userRepository.ids();
    }

    public User findById(@Nullable final String id) {
        return userRepository.findById(id);
    }

    public User findByLogin(final String login) {
        return userRepository.findByLogin(login);
    }

    public void removeById(@Nullable final String id) {
        userRepository.removeById(id);
    }

    public void insert(@Nullable final User user) {
        userRepository.insert(user);
    }

    public void clear() {
        userRepository.clear();
    }

    private List<String> loginList() {
        return userRepository.loginList();
    }

    public boolean existLogin(final String login) {
        return loginList().contains(login);
    }

    public void registry(@Nullable final String login, @Nullable final String password) throws UserLoginBusyException {
        if (login == null || login.isEmpty()) return;
        if (password == null || password.isEmpty()) return;
        if (existLogin(login)) throw new UserLoginBusyException();
        @NotNull final User user = new User();
        user.setLogin(login);
        user.setPasswordHash(DigestUtils.md5Hex(password));
        user.setRole(Status.USER);
        insert(user);
        System.out.println("New user " + login + " add.");
        System.out.println("Please authorization.");
    }

    public void authorization(@Nullable final String login,
                              @Nullable final String password) throws UserNotFoundException {
        if (checkLoginPassword(login, password)) {
            System.out.println("Welcome to TASK MANAGER!");
            final User user = findByLogin(login);
            sessionService.createSession(user.getId());
            System.out.println("USER: " + login + " AUTORIZATION");
            return;
        }
        System.out.println("User not found");
        throw new UserNotFoundException();
    }

    @Override
    public boolean checkLoginPassword(@Nullable final String login, @Nullable final String password) {
        if (login == null || login.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        final User user = findByLogin(login);
        if (user == null) return false;
        return DigestUtils.md5Hex(password).equals(user.getPasswordHash());
    }

    @Override
    public void logout(@Nullable final String userId) {
        if (userId == null || userId.isEmpty()) return;
        final Session session = sessionService.findOnByUserId(userId);
        sessionService.removeById(session.getId());
    }

}
