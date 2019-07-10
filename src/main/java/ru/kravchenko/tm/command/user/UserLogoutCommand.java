package ru.kravchenko.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;

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
        System.out.println("Please enter login: ");
        final @NotNull ITerminalService terminalService = serviceLocator.getTerminalService();
        final @NotNull String userLogin = terminalService.nextLine();
        final @NotNull IUserService userServiceBean = serviceLocator.getUserService();
        userServiceBean.logout(userLogin);
    }

}
