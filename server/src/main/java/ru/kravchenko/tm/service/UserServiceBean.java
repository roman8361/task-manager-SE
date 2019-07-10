package ru.kravchenko.tm.service;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.IUserService;
import ru.kravchenko.tm.entity.*;
import ru.kravchenko.tm.exception.UserNotFoundException;

import java.util.Date;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class UserServiceBean implements IUserService {

    @NotNull
    private final IServiceLocator serviceLocator;

    public UserServiceBean(@NotNull final IServiceLocator serviceLocator) throws UserNotFoundException {
        this.serviceLocator = serviceLocator;
        initAdmin();
        initSimpleUser();
    }

    private void initAdmin() throws UserNotFoundException {
        @NotNull final User admin = new User();
        admin.setLogin("admin");
        admin.setPassword(DigestUtils.md5Hex("admin"));
        admin.setUserStatus(Status.ADMIN);
        serviceLocator.getUserRepository().addUser(admin);
        authorization("admin", "admin");

        Project projectAdmin1 = new Project();
        projectAdmin1.setDescription("setDescription");
        projectAdmin1.setName("setName");
        projectAdmin1.setUserId(admin.getId());
        projectAdmin1.setDateBegin(new Date());
        projectAdmin1.setDateEnd(new Date());
        projectAdmin1.setDisplayName(StatusProjectTask.PROCESS);

        Project projectAdmin2 = new Project();
        projectAdmin2.setDescription("setDescription2");
        projectAdmin2.setName("setName2");
        projectAdmin2.setUserId(admin.getId());
        projectAdmin2.setDateBegin(new Date());
        projectAdmin2.setDateEnd(new Date());
        projectAdmin2.setDisplayName(StatusProjectTask.COMPLETED);

        Project projectAdmin3 = new Project();
        projectAdmin3.setDescription("setDescription3");
        projectAdmin3.setName("setName3");
        projectAdmin3.setUserId(admin.getId());
        projectAdmin3.setDateBegin(new Date());
        projectAdmin3.setDateEnd(new Date());

        serviceLocator.getProjectRepository().addProject(projectAdmin1);
        serviceLocator.getProjectRepository().addProject(projectAdmin2);
        serviceLocator.getProjectRepository().addProject(projectAdmin3);
    }

    private void initSimpleUser() throws UserNotFoundException {
        @NotNull final User simpleUser = new User();
        simpleUser.setLogin("11");
        simpleUser.setPassword(DigestUtils.md5Hex("11"));
        simpleUser.setUserStatus(Status.USER);
        serviceLocator.getUserRepository().addUser(simpleUser);
        authorization("11", "11");
    }

    @Override
    public void registry(@Nullable final String login, @Nullable final String password) {
        if (login == null || login.isEmpty()) return;
        if (password == null || password.isEmpty()) return;
        @NotNull final User user = new User();
        user.setLogin(login);
        user.setPassword(DigestUtils.md5Hex(password));
        user.setUserStatus(Status.USER);
        serviceLocator.getUserRepository().addUser(user);
        System.out.println("New user " + login + " add.");
        System.out.println("Please authorization.");
    }

    public void authorization(@Nullable final String login, @Nullable final String password) throws UserNotFoundException {
        if (checkLoginPassword(login, password)) {
            System.out.println("Welcome to TASK MANAGER!");
            final User user = serviceLocator.getUserRepository().findByLogin(login);
            serviceLocator.getSessionService().createSession(user.getId());
            return;
        }
        System.out.println("User not found");
    }

    @Override
    public void logout(@Nullable final String login, @Nullable final String password) throws UserNotFoundException {
        if (checkLoginPassword(login, password)) {
            final User user = serviceLocator.getUserRepository().findByLogin(login);
            final Session session = serviceLocator.getSessionService().findOnByUserId(user.getId());
            serviceLocator.getSessionRepository().removeById(session.getId());
        }
    }

    @Override
    public boolean checkLoginPassword(@Nullable final String login, @Nullable final String password) throws UserNotFoundException {
        if (login == null || login.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        @Nullable final User user = serviceLocator.getUserRepository().findByLogin(login);
        if (user == null) return false;
        return DigestUtils.md5Hex(password).equals(user.getPassword());
    }

    @Override
    public boolean existLogin(@Nullable final String login) {
        if (login == null || login.isEmpty()) return true;
        for (final User user : serviceLocator.getUserRepository().findAll()) {
            if (login.equals(user.getLogin())) return true;
        }
        return false;
    }

    @Override
    public void displayName(@Nullable final String login) throws UserNotFoundException {
        @Nullable final User user = serviceLocator.getUserRepository().findByLogin(login);
        System.out.println(user.getUserStatus());
    }

}
