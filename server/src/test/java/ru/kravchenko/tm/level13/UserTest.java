package ru.kravchenko.tm.level13;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.entity.Status;
import ru.kravchenko.tm.entity.User;
import ru.kravchenko.tm.exception.UserNotFoundException;
import ru.kravchenko.tm.service.LocatorServiceBean;
import ru.kravchenko.tm.service.UserService;

import java.io.IOException;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

public class UserTest {

    @NotNull
    private IServiceLocator serviceLocator = new LocatorServiceBean();

    private final UserService userDAO = new UserService(serviceLocator);

    private final Lorem lorem = LoremIpsum.getInstance();

    public UserTest() throws Exception {
    }

    @Test
    public void addAnyUserTest() {
        for (int i = 0; i < 10; i++) addOneUser();
    }

    public void addOneUser() {
        final User user = new User();
        user.setLogin(lorem.getFirstName());
        user.setPasswordHash(DigestUtils.md5Hex(lorem.getWords(1)));
        userDAO.insert(user);
        userDAO.commit();
    }

    @Test
    public void clear() {
        userDAO.clear();
        userDAO.commit();
    }

    @Test
    public void findAll() {
        for (User u : userDAO.findAll()) System.out.println(u.getLogin());
    }

    @Test
    public void ids() {
        for (String s : userDAO.ids()) System.out.println(s);
    }

    @Test
    public void findOne() {
        final User user = userDAO.findById("09c77545-f838-4905-8037-2d2c44213046");
        final Status status = user.getRole();
        System.out.println(status);
    }

    @Test
    public void removeById() {
        userDAO.removeById("21042d6b-0a04-4305-a423-dbfd0487baf0");
        userDAO.commit();
    }

    @Test
    public void loginList() {
        List<String> list = userDAO.loginList();
        System.out.println(list.contains("roma"));
    }

    @Test
    public void findByLogin() {
        System.out.println(userDAO.findByLogin("rom").getId());
    }

    @Test
    public void auroriz() {
        try {
            userDAO.authorization("rom", "11");
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            userDAO.roolback();
        }
    }

    @Test
    public void findByUserId() {
        System.out.println();
    }

    @Test
    public void logout() {
        userDAO.logout("f0faaa69-936d-45bb-86d8-c065a38cf8c3");
    }




}
