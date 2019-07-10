package ru.kravchenko.tm.service;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.IUserService;
import ru.kravchenko.tm.entity.Status;
import ru.kravchenko.tm.entity.User;
import ru.kravchenko.tm.repository.UserRepositoryBean;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class UserServiceBean implements IUserService {

    @NotNull
    private final IServiceLocator serviceLocator;

    @NotNull
    private final UserRepositoryBean userRepositoryBean;

    public UserServiceBean(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        userRepositoryBean = (UserRepositoryBean) serviceLocator.getUserRepository();
        initAdmin();
        initSimpleUser();
    }

    private void initAdmin() {
        final User admin = new User();
        admin.setLogin("admin");
        admin.setPassword(DigestUtils.md5Hex("admin"));
        admin.setUserStatus(Status.ADMIN);
        userRepositoryBean.addUser(admin.getLogin(), admin, userRepositoryBean.getUsersLoginBase());
        userRepositoryBean.addUser(admin.getLogin(), admin, userRepositoryBean.getUsersBaseDate());
    }

    private void initSimpleUser() {
        final User simpleUser = new User();
        simpleUser.setLogin("11");
        simpleUser.setPassword(DigestUtils.md5Hex("11"));
        simpleUser.setUserStatus(Status.USER);
        userRepositoryBean.addUser(simpleUser.getLogin(), simpleUser, userRepositoryBean.getUsersLoginBase());
        userRepositoryBean.addUser(simpleUser.getLogin(), simpleUser, userRepositoryBean.getUsersBaseDate());
    }

    @Override
    public boolean registry(@Nullable final String login, @Nullable final String password) {
        if (login == null || login.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        if (existsDateBase(login)) return false;
        @NotNull final User user = new User();
        user.setLogin(login);
        user.setPassword(DigestUtils.md5Hex(password));
        user.setUserStatus(Status.USER);
        userRepositoryBean.addUser(login, user, userRepositoryBean.getUsersBaseDate());
        System.out.println("New user " + login + " add.");
        System.out.println("Please authorization.");
        return true;
    }

    public void authorization(@Nullable final String login, @Nullable final String password) {
        if (checkAuthorization(login, DigestUtils.md5Hex(password))) {
            System.out.println("Welcome to TASK MANAGER!");
            @NotNull final User user = new User();
            user.setLogin(login);
            user.setPassword(DigestUtils.md5Hex(password));
            userRepositoryBean.addUser(login, user, userRepositoryBean.getUsersLoginBase());
            return;
        }
        System.out.println("Not logged in");
        System.out.println("Try again...");
    }

    @Override
    public void logout(@Nullable final String login) {
        if (existsLoginBase(login)) {
            assert userRepositoryBean.getUsersLoginBase() != null;
            userRepositoryBean.removeById(login, userRepositoryBean.getUsersLoginBase());
            System.out.println("You logout. Come back later...");
            return;
        }
        System.out.println("Not correct logout. Try again.");
    }

    public boolean checkAuthorization(@Nullable final String login, @Nullable final String password) {
        if (login == null || login.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        @Nullable final User user = userRepositoryBean.findByLogin(login, userRepositoryBean.getUsersBaseDate());
        if (user == null) return false;
        return password.equals(user.getPassword());
    }

    @Override
    public boolean check(@Nullable final String login, @Nullable final String password) {
        if (login == null || login.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        @Nullable final User user = userRepositoryBean.findByLogin(login, userRepositoryBean.getUsersLoginBase());
        if (user == null) return false;
        return password.equals(user.getPassword());
    }

    @Override
    public boolean existsDateBase(@Nullable final String login) {
        if (login == null || login.isEmpty()) return false;
        return userRepositoryBean.getUsersBaseDate().containsKey(login);
    }

    @Override
    public boolean existsLoginBase(@Nullable final String login) {
        if (login == null || login.isEmpty()) return false;
        return userRepositoryBean.getUsersLoginBase().containsKey(login);
    }

    @Override
    public boolean setPassword(@Nullable final String login,
                               @Nullable final String passwordOld,
                               @Nullable final String passwordNew) {
        if (!check(login, passwordOld)) return false;
        @Nullable final User user = userRepositoryBean.findByLogin(login, userRepositoryBean.getUsersBaseDate());
        if (user == null) return false;
        user.setPassword(passwordNew);
        return true;
    }

    @Override
    public void displayName(@Nullable final String login) {
        @Nullable final User user = userRepositoryBean.findByLogin(login, userRepositoryBean.getUsersBaseDate());
        //     assert user != null;
        System.out.println(user.getUserStatus());
    }

    @Override
    public void changePasswordUser(@Nullable final String login,
                                   @NotNull final String newPassword) {
        final User user = userRepositoryBean.findByLogin(login, userRepositoryBean.getUsersBaseDate());
        user.setPassword(DigestUtils.md5Hex(newPassword));
    }

    @Override
    public void changeProfileUser(@Nullable final String oldLogin,
                                  @Nullable final String newLogin,
                                  @Nullable final String newPassword) {
        userRepositoryBean.getUsersBaseDate().remove(oldLogin);
        userRepositoryBean.getUsersLoginBase().remove(oldLogin);
        if (registry(newLogin, newPassword)) {
            System.out.println("New user add");
            return;
        }
        System.out.println("Login is busy");
    }

}
