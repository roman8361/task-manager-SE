package ru.kravchenko.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.*;

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
    public void execute() throws SessionNotFoundException_Exception, UserNotFoundException_Exception {
        System.out.println("***User Authorization Command***");
        @NotNull final UserEndpoint userEndpoint = serviceLocator.getUserEndpoint();
        @NotNull final SessionEndpoint sessionEndpoint = serviceLocator.getSessionEndpoint();

        userEndpoint.authorization("1", "1");
        final @NotNull SessionDTO sessionDTO = sessionEndpoint.openSession("1");
        serviceLocator.setCurrentSession(sessionDTO);
        System.out.println("USER ID: " + sessionDTO.getUserId());
    }

}


