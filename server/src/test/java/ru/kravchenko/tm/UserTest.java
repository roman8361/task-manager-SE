package ru.kravchenko.tm;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.tm.api.repository.UserRepository;
import ru.kravchenko.tm.bootstrap.AppConfig;
import ru.kravchenko.tm.model.entity.User;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class UserTest {

    private Lorem lorem = new LoremIpsum();

    @Autowired
    private UserRepository userRepository;

//    @Test
    public void addAnyUser() { for (int i = 0; i < 5; i++) addOneUser(); }

    private void addOneUser() { userRepository.save(dateUser()); }

    private User dateUser() {
        final User user = new User();
        user.setLogin(lorem.getFirstName());
        user.setPasswordHash(lorem.getZipCode());
        return user;
    }

//    @Test
    public void findByLogin() {
        System.out.println(userRepository.findByLogin("Clair").getPasswordHash());
    }

//    @Test
    public void removeByUser() {
        userRepository.delete(userRepository.findById("25ba227a-ec2e-4451-a6f1-539cb47a10a2").get());
    }

//    @Test
    public void removeById() {
        userRepository.deleteById("e8807b25-18b1-4f80-ab54-7da8ec5e9ec1");
    }

//    @Test
    public void clearAll() {
        userRepository.deleteAll();
    }

//    @Test
    public void findAll() {
        List<User> users = userRepository.findAll();
        for (User u: users) System.out.println(u);
    }

//    @Test
    public void loginList() {
        List<String> loginList = userRepository.loginList();
        for (String s: loginList) System.out.println(s);
    }

    @Test //OK
    public void userCRUD() {
        final List<User> userList = userRepository.findAll();
        final User user = new User();
        user.setLogin(lorem.getFirstName());
        user.setPasswordHash(lorem.getZipCode());
        userRepository.save(user);
        final User userInsert = userRepository.findById(user.getId()).get();
        Assert.assertNotNull(userInsert);
        userRepository.deleteById(userInsert.getId());
        Assert.assertNull(userRepository.findByLogin(user.getId()));
    }

}

