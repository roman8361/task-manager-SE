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
    public void addAnyProject() {
        for (int i = 0; i < 10; i++) addOneUser();
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
    public void clearUser() {
        @Nullable final List<User> users = userRepository.findAll();
        users.forEach(userRepository::remove);
        System.out.println(users);
    }

    @Test
    public void findById() {
        System.out.println(userRepository.findBy("11652315-e242-47ff-bbe9-9764030fb791").getLogin());
    }

    @Test
    public void removeById() {
        userRepository.removeById("2b5a07e6-1f0e-453e-88b5-4b60a8e6d790");
    }

    @Test
    public void removeByEntity() { //TODO
       final User user = userRepository.findBy("2b5a07e6-1f0e-453e-88b5-4b60a8e6d790");
       userRepository.remove(user);
    }

    @Test
    public void clear() {
        userRepository.removeAll();
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

