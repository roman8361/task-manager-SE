package ru.kravchenko.tm;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.tm.api.repository.SessionRepository;
import ru.kravchenko.tm.api.repository.UserRepository;
import ru.kravchenko.tm.bootstrap.AppConfig;
import ru.kravchenko.tm.model.entity.Session;
import ru.kravchenko.tm.model.entity.User;

import java.util.Date;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class SessionTest {

    private Lorem lorem = new LoremIpsum();

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private UserRepository userRepository;

//    @Test
    public void addAnySession() {
        for (int i = 0; i < 1; i++) addOneSession();
    }

    private void addOneSession() {
        sessionRepository.save(date());
    }

    private Session date() {
        final Session session = new Session();
        session.setSignature(lorem.getUrl());
        session.setTimestamp(new Date());
        session.setUser(userRepository.findById("15f8f58e-8342-4113-89c9-c4590e70bba1").get());
        return session;
    }

//    @Test
    public void clear() {
        sessionRepository.deleteAll();
    }


//    @Test
    public void removeById() {
        sessionRepository.removeById("525f7e02-cf36-4acc-a9a3-9b43603b0b66");
    }

//    @Test
    public void findAllSession() {
        System.out.println(sessionRepository.findAll());
    }

   // @Test
    public void findAllIds() {
        System.out.println(sessionRepository.findAllId());
    }

 //   @Test
    public void findById() {
        System.out.println(sessionRepository.findById("e041fd4a-579b-4623-9d03-62ff3b8e5638").get().getUser());
    }

  //  @Test
    public void findOnByUserId() {
        final User user = userRepository.findById("15f8f58e-8342-4113-89c9-c4590e70bba1").get();
        System.out.println(sessionRepository.findByUser(user).get(0).getSignature());
    }

    @Test
    public void sessionTestCRUD() {
        final List<Session> sessionList = sessionRepository.findAll();
        final Session session = new Session();
        session.setTimestamp(new Date());
        session.setSignature(lorem.getUrl());
        sessionRepository.save(session);

        final Session projectInsert = sessionRepository.findById(session.getId()).get();
        Assert.assertNotNull(projectInsert);
        sessionRepository.removeById(projectInsert.getId());
        Assert.assertNotNull(sessionRepository.findById(session.getId()));
    }

}
