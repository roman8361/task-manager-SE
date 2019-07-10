package ru.kravchenko.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;
import ru.kravchenko.tm.exception.UserLoginBusyException;

/**
 * @author Roman Kravchenko
 */

public class UserRegistryCommand extends AbstractCommand {

    @Override
    public String getName() { return "user-registry"; }

    @Override
    public void getDescription() { System.out.println("user-registry: Registry new user."); }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String userLogin = terminalService.nextLine();
        System.out.println("Please enter your password: ");
        @NotNull final String userPassword= terminalService.nextLine();
        @NotNull final IUserService userServiceBean = serviceLocator.getUserService();
        if(userServiceBean.registry(userLogin, userPassword)) return;
        try {
            throw new UserLoginBusyException();
        } catch (@NotNull final UserLoginBusyException e) {
            e.printStackTrace();
        }
    }

}
