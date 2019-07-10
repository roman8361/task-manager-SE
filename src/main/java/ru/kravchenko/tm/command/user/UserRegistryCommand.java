package ru.kravchenko.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;

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
        final @NotNull ITerminalService terminalService = serviceLocator.getTerminalService();
        final @NotNull String userLogin = terminalService.nextLine();
        System.out.println("Please enter your password: ");
        final @NotNull String userPassword= terminalService.nextLine();
        final @NotNull IUserService userServiceBean = serviceLocator.getUserService();
        if(userServiceBean.registry(userLogin, userPassword)) return;
        System.out.println("Sorry, login is busy...try again.");
    }

}
