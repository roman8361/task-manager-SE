package ru.kravchenko.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
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
        userEndpoint.authorization("rom", "rom");
        try {
            serviceLocator.setSession(serviceLocator.getSessionEndpoint().openSession("rom"));
        } catch (UserNotFoundException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("USER AUTORIZATION");
        System.out.println(serviceLocator.getSession().getUserId());
    }

}
