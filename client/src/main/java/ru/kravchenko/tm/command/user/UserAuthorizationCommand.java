package ru.kravchenko.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.SessionEndpoint;
import ru.kravchenko.tm.endpoint.SessionNotFoundException_Exception;
import ru.kravchenko.tm.endpoint.UserEndpoint;
import ru.kravchenko.tm.endpoint.UserNotFoundException_Exception;

/**
 * @author Roman Kravchenko
 */

public class UserAuthorizationCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "user-authorization";
    }

    @Override
    public void getDescription() {
        System.out.println("user-authorization: Login user.");
    }

    @Override
    public void execute() {
        System.out.println("***User Authorization Command***");
        @NotNull final UserEndpoint userEndpoint = serviceLocator.getUserEndpoint();
        @NotNull final SessionEndpoint sessionEndpoint = serviceLocator.getSessionEndpoint();
        try {
            userEndpoint.authorization("roma", "roma");
        } catch (UserNotFoundException_Exception e) {
            e.printStackTrace();
            return;
        }
        try {
            serviceLocator.setSession(sessionEndpoint.openSession("roma"));
        } catch (SessionNotFoundException_Exception e) {
            e.printStackTrace();
            return;
        } catch (UserNotFoundException_Exception e) {
            e.printStackTrace();
            return;
        }

        System.out.println("USER AUTORIZATION");
        System.out.println("SESSION getId: " + serviceLocator.getSession().getId());
        System.out.println(serviceLocator.getSession());
    }

}
