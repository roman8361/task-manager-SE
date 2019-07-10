package ru.kravchenko.tm.level13;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.Test;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ISessionService;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.exception.AccessForbiddenException;
import ru.kravchenko.tm.service.LocatorServiceBean;
import ru.kravchenko.tm.service.SessionService;

import java.io.IOException;
import java.util.Date;

/**
 * @author Roman Kravchenko
 */

public class SessionTest {

    private final SessionService sessionDAO = new SessionService();

    private final IServiceLocator serviceLocator = new LocatorServiceBean();

    private final Lorem lorem = new LoremIpsum();

    public SessionTest() throws Exception {
    }

    @Test
    public void addSession() {
        for (int i = 0; i < 5; i++) addOne();
    }

    private void addOne() {
        final Session session = new Session();
        session.setSignature(lorem.getUrl());
        session.setTimestamp(new Date());
        //    session.setUserId("35a22b46-f8b6-4187-9963-efb7eb880226");
        sessionDAO.insert(session);
        sessionDAO.commit();
    }

    @Test
    public void ids() {
        for (String s : sessionDAO.ids()) System.out.println(s);
    }

    @Test
    public void findAll() {
        for (Session s : sessionDAO.findAll()) System.out.println(s.getSignature());
    }

    @Test
    public void findOne() {
        System.out.println(sessionDAO.findById("6838cded-d343-4182-be9b-cce783d075c7").getSignature());
    }

    @Test
    public void removeById() {
        sessionDAO.removeById("6838cded-d343-4182-be9b-cce783d075c7");
        sessionDAO.commit();
    }

    @Test
    public void clear() {
        sessionDAO.clear();
        sessionDAO.commit();
    }

    @Test
    public void findByUserId() {
        System.out.println(sessionDAO.findOnByUserId("f0faaa69-936d-45bb-86d8-c065a38cf8c3").getSignature());
    }

    @Test
    public void removeByIdService() {
        serviceLocator.getSessionService().removeById("991e5565-9066-41ca-a8e2-d865ec4c55ca");
    }

    @Test
    public void findByIdService() {
        System.out.println(serviceLocator.getSessionService().
                findOnByUserId("85df598f-d681-4cb1-8fd1-060c6d005013").getSignature());
    }

    @Test
    public void sessionValidate() throws AccessForbiddenException {
        Session session = serviceLocator.getSessionService().findOnByUserId("e06c0dbd-708d-4092-841d-5d66e5af5497");
        serviceLocator.getSessionService().validate(session);
    }

    @Test
    public void sessionValidate2() throws AccessForbiddenException {
        Session session = serviceLocator.getSessionService().findById("bc92fb67-44a4-4938-a206-72c5ce2a1e8f");
        serviceLocator.getSessionService().validate(session);
    }

}
