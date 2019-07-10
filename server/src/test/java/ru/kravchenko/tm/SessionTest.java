package ru.kravchenko.tm;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.kravchenko.tm.api.repository.SessionRepository;
import ru.kravchenko.tm.api.repository.UserRepository;
import ru.kravchenko.tm.model.entity.Session;
import ru.kravchenko.tm.model.entity.User;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@RunWith(CdiTestRunner.class)
public class SessionTest {

    private Lorem lorem = new LoremIpsum();

    @Inject
    private SessionRepository sessionRepository;

    @Inject
    private UserRepository userRepository;

    @Test
    public void addAnySession() {
        for (int i = 0; i < 1; i++) addOneSession();
    }

    private void addOneSession() {
        sessionRepository.persist(date());
    }

    private Session date() {
    final Session session = new Session();
    session.setSignature(lorem.getUrl());
    session.setTimestamp(new Date());
    session.setUser(userRepository.findBy("2000e468-8dd3-4479-a7b3-95c12b9ea827"));
    return session;
    }

    @Test
    public void clear() { sessionRepository.removeAll(); }

    @Test
    public void clear2() {
        List<String> ids = sessionRepository.findAllId();
        for (String s: ids) sessionRepository.removeById(s);
    }

    @Test
    public void removeById() { sessionRepository.removeById("151425b9-aa54-4438-86f8-296eaa5cacc5"); }

    @Test
    public void findAllSession() {
        System.out.println(sessionRepository.findAll());
    }

    @Test
    public void findAllIds() {
        System.out.println(sessionRepository.findAllId());
    }

    @Test
    public void findById() {
        System.out.println(sessionRepository.findBy("e3994265-c9d8-49d4-862c-0073010c7da0").getUser());
    }

    @Test
    public void findOnByUserId() {
        final User user = userRepository.findBy("8a6268f6-c9c1-4419-a6e3-584c10b7eec7");
        System.out.println(sessionRepository.findByUser(user).get(0).getSignature());
    }

    @Test
    public void sessionTestCRUD() {
        final List<Session> sessionList = sessionRepository.findAll();
        final Session session = new Session();
        session.setUser(userRepository.findBy("8a6268f6-c9c1-4419-a6e3-584c10b7eec7"));
        session.setTimestamp(new Date());
        session.setSignature(lorem.getUrl());
        sessionRepository.persist(session);

        final Session projectInsert = sessionRepository.findBy(session.getId());
        Assert.assertNotNull(projectInsert);
        sessionRepository.removeById(projectInsert.getId());
        Assert.assertNull(sessionRepository.findBy(session.getId()));
    }

}
