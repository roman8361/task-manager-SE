package ru.kravchenko.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.Session;
import ru.kravchenko.tm.endpoint.SessionNotFoundException_Exception;
import ru.kravchenko.tm.endpoint.UserEndpoint;

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
    public void execute() throws SessionNotFoundException_Exception {
        System.out.println("***User Logout Command***");
        @NotNull final UserEndpoint userEndpoint = serviceLocator.getUserEndpoint();
        final Session session = serviceLocator.getSession();
        try {
            serviceLocator.getSessionEndpoint().validateSession(session);
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        userEndpoint.logout(serviceLocator.getSession());
        System.out.println("Come back later...");
    }

}
