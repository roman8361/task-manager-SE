package ru.kravchenko.tm;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.jetbrains.annotations.Nullable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.kravchenko.tm.api.repository.UserRepository;
import ru.kravchenko.tm.model.entity.User;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@RunWith(CdiTestRunner.class)
public class UserTest {

    @Inject
    private UserRepository userRepository;

    private Lorem lorem = new LoremIpsum();

    @Test
    public void addAnyUser() {
        for (int i = 0; i < 5; i++) addOneUser();
    }

    private void addOneUser() {
        userRepository.persist(date());
    }

    private User date() {
        final User user = new User();
        user.setLogin(lorem.getFirstName());
        user.setPasswordHash(lorem.getZipCode());
        return user;
    }

    @Test
    public void findById() {
        System.out.println(userRepository.findBy("48c7d462-1023-43d2-9c49-7d253a3fe2a0").getLogin());
    }

    @Test
    public void removeById() {
        userRepository.removeById("e9770985-a9c3-4235-8431-fe2fbf718797");
    }

    @Test
    public void clear() {
        userRepository.removeAll();
    }

    @Test
    public void clear2() {
        List<String> ids = userRepository.findByAllId();
        for (String s: ids) userRepository.removeById(s);
    }

    @Test
    public void userCRUD() {
        final List<User> userList = userRepository.findAll();
        final User user = new User();
        user.setLogin(lorem.getFirstName());
        user.setPasswordHash(lorem.getZipCode());
        userRepository.persist(user);

        final User catInsert = userRepository.findBy(user.getId());
        Assert.assertNotNull(catInsert);
        userRepository.removeById(catInsert.getId());
        Assert.assertNull(userRepository.findBy(user.getId()));
    }

    @Test
    public void ids() {
        List<String> ids = userRepository.findByAllId();
        System.out.println(ids);
    }

    @Test
    public void findByLogin() {
        System.out.println(userRepository.findByLogin("Gay").getPasswordHash());
    }

    @Test
    public void findLoginList() {
        for (String s: userRepository.loginList()) System.out.println(s);
    }

}

