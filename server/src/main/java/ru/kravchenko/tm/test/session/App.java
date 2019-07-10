package ru.kravchenko.tm.test.session;

import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.entity.User;
import ru.kravchenko.tm.exception.UserNotFoundException;
import ru.kravchenko.tm.service.LocatorServiceBean;
import ru.kravchenko.tm.service.SessionServiceBean;

/**
 * @author Roman Kravchenko
 */

public class App {

    public static void main(String[] args) throws UserNotFoundException {
        IServiceLocator serviceLocator = new LocatorServiceBean();
        SessionServiceBean sessionServiceBean = new SessionServiceBean(serviceLocator);
        User user = new User();
        sessionServiceBean.createSession(user.getId());
    }

}
