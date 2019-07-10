package ru.kravchenko.tm.service;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.Status;
import ru.kravchenko.tm.entity.User;
import ru.kravchenko.tm.repository.UserService;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class UserServiceBean implements UserService {

    public UserServiceBean() {
        initAdmin();
        initSimpleUser();
    }

    @NotNull
    private Map<String, User> usersBaseDate = new LinkedHashMap<>();

    private Map<String, User> usersLoginBase = new LinkedHashMap<>();

    private void initAdmin() {
        final User admin = new User();
        admin.setLogin("admin");
        admin.setPassword(DigestUtils.md5Hex("admin"));
        admin.setUserStatus(Status.ADMIN);
        usersBaseDate.put(admin.getLogin(), admin);
        usersLoginBase.put(admin.getLogin(), admin);
    }

    private void initSimpleUser() {
        final User simpleUser = new User();
        simpleUser.setLogin("11");
        simpleUser.setPassword(DigestUtils.md5Hex("11"));
        simpleUser.setUserStatus(Status.USER);
        usersBaseDate.put(simpleUser.getLogin(), simpleUser);
        usersLoginBase.put(simpleUser.getLogin(), simpleUser);
    }

    @Override
    public boolean registry(@Nullable String login, @Nullable String password) {
        if (login == null || login.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        if (existsDateBase(login)) return false;
        @NotNull final User user = new User();
        user.setLogin(login);
        user.setPassword(DigestUtils.md5Hex(password));
        user.setUserStatus(Status.USER);
        usersBaseDate.put(login, user);
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
            usersLoginBase.put(login, user);
            return;
        }
        System.out.println("Not logged in");
        System.out.println("Try again...");
    }

    @Override
    public void logout(@Nullable final String login) {
        if (existsLoginBase(login)) {
            usersLoginBase.remove(login);
            System.out.println("You logout. Come back later...");
            return;
        }
        System.out.println("Not correct logout. Try again.");
    }

    @Override
    public @Nullable User findByLogin(@Nullable final String login) {
        if (login == null || login.isEmpty()) return null;
        return usersLoginBase.get(login);
    }


    public @Nullable User findByLoginBaseDate(@Nullable final String login) {
        if (login == null || login.isEmpty()) return null;
        return usersBaseDate.get(login);
    }


    public boolean checkAuthorization(@Nullable final String login, @Nullable final String password) {
        if (login == null || login.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        @Nullable final User user = findByLoginBaseDate(login);
        if (user == null) return false;
        return password.equals(user.getPassword());
    }

    @Override
    public boolean check(@Nullable final String login, @Nullable final String password) {
        if (login == null || login.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        @Nullable final User user = findByLogin(login);
        if (user == null) return false;
        return password.equals(user.getPassword());
    }



    @Override
    public boolean existsDateBase(@Nullable final String login) {
        if (login == null || login.isEmpty()) return false;
        return usersBaseDate.containsKey(login);
    }

    @Override
    public boolean existsLoginBase(@Nullable String login) {
        if (login == null || login.isEmpty()) return false;
        return usersLoginBase.containsKey(login);
    }

    @Override
    public boolean setPassword(@Nullable String login,
                               @Nullable String passwordOld,
                               @Nullable String passwordNew) {
        if (!check(login, passwordOld)) return false;
        if (passwordNew == null || passwordNew.isEmpty()) return false;
        @Nullable final User user = findByLogin(login);
        if (user == null) return false;
        user.setPassword(passwordNew);
        return true;
    }

    @Override
    public void displayName(@Nullable String login) {
        @Nullable final User user = findByLogin(login);
        //     assert user != null;
        System.out.println(user.getUserStatus());
    }

    @Override
    public void changePasswordUser(@Nullable String login,
                                   @NotNull String newPassword) {

        final User user = findByLogin(login);
        user.setPassword(DigestUtils.md5Hex(newPassword));
    }

    @Override
    public void changeProfileUser(@Nullable String oldLogin,
                                  @Nullable String newLogin,
                                  @Nullable String newPassword) {
        usersBaseDate.remove(oldLogin);
        if (registry(newLogin, newPassword)) {
            System.out.println("New user add");
            return;
        }
        System.out.println("Login is busy");
    }

    public void showAllUsersBaseDate() {
        System.out.println(usersBaseDate);
    }

    public void showAllUsersLoginBase() {
        System.out.println(usersLoginBase);
    }

}
