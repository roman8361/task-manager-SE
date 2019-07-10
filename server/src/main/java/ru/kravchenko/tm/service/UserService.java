package ru.kravchenko.tm.service;

import com.sun.istack.internal.Nullable;
import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.IUserService;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.entity.Status;
import ru.kravchenko.tm.entity.User;
import ru.kravchenko.tm.exception.UserLoginBusyException;
import ru.kravchenko.tm.exception.UserNotFoundException;
import ru.kravchenko.tm.repository.UserRepository;

import java.io.IOException;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

public class UserService extends AbstractService implements IUserService {

    private IServiceLocator serviceLocator;

    private final UserRepository userRepository;

    public UserService(IServiceLocator serviceLocator) throws IOException {
        userRepository = sqlSession.getMapper(UserRepository.class);
        this.serviceLocator = serviceLocator;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<String> ids() {
        return userRepository.ids();
    }

    public User findById(@Nullable final String id) {
        return userRepository.findOne(id);
    }

    public User findByLogin(final String login) {
        return userRepository.findByLogin(login);
    }

    public void removeById(@Nullable final String id) {
        try {
            userRepository.removeById(id);
            commit();
        } catch (Exception e) {
            roolback();
            e.printStackTrace();
        }
    }

    public void insert(@Nullable final User user) {
        try {
            userRepository.insert(user);
            commit();
        } catch (Exception e) {
            roolback();
            e.printStackTrace();
        }
    }

    public void clear() {
        try {
            userRepository.clear();
            commit();
        } catch (Exception e) {
            roolback();
            e.printStackTrace();
        }
    }

    public void commit() {
        sqlSession.commit();
    }

    public void roolback() {
        sqlSession.rollback();
    }

    public List<String> loginList() {
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
        commit();
        System.out.println("New user " + login + " add.");
        System.out.println("Please authorization.");
    }

    public void authorization(@Nullable final String login,
                              @Nullable final String password) throws UserNotFoundException {
        if (checkLoginPassword(login, password)) {
            System.out.println("Welcome to TASK MANAGER!");
            final User user = findByLogin(login);
            serviceLocator.getSessionService().createSession(user.getId());
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
        final Session session = serviceLocator.getSessionService().findOnByUserId(userId);
        serviceLocator.getSessionService().removeById(session.getId());
    }

}
