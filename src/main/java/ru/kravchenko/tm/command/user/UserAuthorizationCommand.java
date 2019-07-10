package ru.kravchenko.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;

/**
 * @author Roman Kravchenko
 */
public class UserAuthorizationCommand extends AbstractCommand {

    @Override
    public String getName() { return  "user-authorization"; }

    @Override
    public void getDescription() { System.out.println("user-authorization: Login user."); }

    @Override
    public void execute() {
        System.out.println("Please enter login: ");
        final @NotNull ITerminalService terminalService = serviceLocator.getTerminalService();
        final @NotNull String userLogin = terminalService.nextLine();
        System.out.println("Please enter password: ");
        final String userPassword= terminalService.nextLine();
        final  @NotNull IUserService userServiceBean = serviceLocator.getUserService();
        userServiceBean.authorization(userLogin, userPassword);
    }

}
