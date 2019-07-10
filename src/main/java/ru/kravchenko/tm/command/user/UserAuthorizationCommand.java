package ru.kravchenko.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;
import ru.kravchenko.tm.exception.UserNotCorrectInputException;

/**
 * @author Roman Kravchenko
 */

public class UserAuthorizationCommand extends AbstractCommand {

    @Override
    public String getName() { return  "user-authorization"; }

    @Override
    public void getDescription() { System.out.println("user-authorization: Login user."); }

    @Override
    public void execute () {
        System.out.println("Please enter login: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String userLogin = terminalService.nextLine();
        System.out.println("Please enter password: ");
        @NotNull final String userPassword= terminalService.nextLine();
        @NotNull final IUserService userServiceBean = serviceLocator.getUserService();
        try {
            userServiceBean.authorization(userLogin, userPassword);
        } catch (@NotNull final UserNotCorrectInputException e) {
            e.printStackTrace();
        }
    }

}
