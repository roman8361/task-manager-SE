package ru.kravchenko.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;

/**
 * @author Roman Kravchenko
 */
public class UserLogoutCommand extends AbstractCommand {

    @NotNull
    private final IServiceLocator serviceLocator;

    @NotNull
    private final ITerminalService terminalService;

    @NotNull
    private final IUserService userServiceBean;

    public UserLogoutCommand(final @NotNull IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        this.terminalService = serviceLocator.getTerminalService();
        this.userServiceBean = serviceLocator.getUserService();
    }

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
        final String userLogin = terminalService.nextLine();
        userServiceBean.logout(userLogin);
    }

}
