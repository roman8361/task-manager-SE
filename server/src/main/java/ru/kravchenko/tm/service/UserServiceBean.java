package ru.kravchenko.tm.service;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.IUserService;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.entity.Status;
import ru.kravchenko.tm.entity.User;
import ru.kravchenko.tm.exception.UserLoginBusyException;
import ru.kravchenko.tm.exception.UserNotFoundException;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class UserServiceBean implements IUserService {

    @NotNull
    private final IServiceLocator serviceLocator;

    public UserServiceBean(@NotNull final IServiceLocator serviceLocator) throws Exception {
        this.serviceLocator = serviceLocator;
    }

    public void initSimpleUser() throws Exception {
        @NotNull final User simpleUser = new User();
        simpleUser.setLogin("11");
        simpleUser.setPasswordHash(DigestUtils.md5Hex("11"));
        simpleUser.setRole(Status.USER);
        registry(simpleUser.getLogin(), simpleUser.getPasswordHash());
        authorization("11", "111");
    }

    @Override
    @SneakyThrows
    public void registry(@Nullable final String login, @Nullable final String password){
        if (login == null || login.isEmpty()) return;
        if (password == null || password.isEmpty()) return;
        if (existLogin(login)) throw new UserLoginBusyException();
        @NotNull final User user = new User();
        user.setLogin(login);
        user.setPasswordHash(DigestUtils.md5Hex(password));
        user.setRole(Status.USER);
        serviceLocator.getUserRepository().addUser(user);
        System.out.println("New user " + login + " add.");
        System.out.println("Please authorization.");
    }

    @SneakyThrows
    public void authorization(@Nullable final String login, @Nullable final String password) throws UserNotFoundException {
        if (checkLoginPassword(login, password)) {
            System.out.println("Welcome to TASK MANAGER!");
            final User user = serviceLocator.getUserRepository().findByLogin(login);
            serviceLocator.getSessionService().createSession(user.getId());
            System.out.println("USER: " + login +" AUTORIZATION");
            return;
        }
        System.out.println("User not found");
        throw new UserNotFoundException();
    }

    @Override
    @SneakyThrows
    public void logout(@Nullable final String userId) {
        if (userId == null || userId.isEmpty()) return;
        final Session session = serviceLocator.getSessionService().findOnByUserId(userId);
        serviceLocator.getSessionRepository().removeById(session.getId());
    }

    @Override
    @SneakyThrows
    public boolean checkLoginPassword(@Nullable final String login, @Nullable final String password){
        if (login == null || login.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        final User user = serviceLocator.getUserRepository().findByLogin(login);
        if (user == null) return false;
        return DigestUtils.md5Hex(password).equals(user.getPasswordHash());
    }

    @Override
    @SneakyThrows
    public boolean existLogin(@Nullable final String login){
        if (serviceLocator.getUserRepository().findByLogin(login) == null) return false;
        return true;
    }

    @Override
    public void displayName(@Nullable final String login) throws UserNotFoundException {
    }

}
