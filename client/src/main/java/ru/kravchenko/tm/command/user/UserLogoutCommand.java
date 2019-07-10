package ru.kravchenko.tm.command.user;

import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.Session;

/**
 * @author Roman Kravchenko
 */

public class UserLogoutCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "user-logout";
    }

    @Override
    public void getDescription() {
        System.out.println("user-logout: Logout user.");
    }

    @Override
    public void execute() {
        System.out.println("***User Logout Command***");
        final Session session = serviceLocator.getSession();

        try {
            serviceLocator.getSessionEndpoint().validateSession(session);
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        serviceLocator.getUserEndpoint().logout(session);
        System.out.println("Come back later...");
    }

}
