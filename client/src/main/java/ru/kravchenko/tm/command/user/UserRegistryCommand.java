package ru.kravchenko.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.endpoint.UserEndpoint;
import ru.kravchenko.tm.endpoint.UserLoginBusyException_Exception;

/**
 * @author Roman Kravchenko
 */

public class UserRegistryCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "user-registry";
    }

    @Override
    public void getDescription() {
        System.out.println("user-registry: Registry new user.");
    }

    @Override
    public void execute() {
        System.out.println("***User Registry Command***");
        @NotNull final UserEndpoint userEndpoint = serviceLocator.getUserEndpoint();

        try {
            userEndpoint.registryUser("1", "1");
        } catch (UserLoginBusyException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("USER REGISTRY");
    }

}
