package ru.kravchenko.tm.command.user;

import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.SessionDTO;

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
        final SessionDTO sessionDTO = serviceLocator.getCurrentSession();
        try {
            serviceLocator.getSessionEndpoint().validateSession(sessionDTO);
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        serviceLocator.getUserEndpoint().logout(sessionDTO);
        System.out.println("Come back later...");
    }

}
