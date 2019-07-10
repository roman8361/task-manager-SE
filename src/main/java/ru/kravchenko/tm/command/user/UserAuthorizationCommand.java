package ru.kravchenko.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.UserServiceBean;
import ru.kravchenko.tm.utils.TerminalService;

/**
 * @author Roman Kravchenko
 */
public class UserAuthorizationCommand extends AbstractCommand {

    private TerminalService terminalService = new TerminalService();

    @NotNull
    private UserServiceBean userServiceBean;

    public UserAuthorizationCommand(@NotNull UserServiceBean userServiceBean) {
        this.userServiceBean = userServiceBean;
    }

    @Override
    public String getName() { return  "user-authorization"; }

    @Override
    public void getDescription() { System.out.println("user-authorization: Login user."); }

    @Override
    public void execute() {
        System.out.println("Please enter login: ");
        final String userLogin = terminalService.nextLine();
        System.out.println("Please enter password: ");
        final String userPassword= terminalService.nextLine();
        userServiceBean.authorization(userLogin, userPassword);
    }

}
