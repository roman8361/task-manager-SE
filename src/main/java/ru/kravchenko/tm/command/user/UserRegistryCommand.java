package ru.kravchenko.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.UserServiceBean;
import ru.kravchenko.tm.utils.TerminalService;

/**
 * @author Roman Kravchenko
 */

public class UserRegistryCommand extends AbstractCommand {

    private TerminalService terminalService = new TerminalService();

    @NotNull
    private UserServiceBean userServiceBean;

    public UserRegistryCommand(@NotNull UserServiceBean userServiceBean) {
        this.userServiceBean = userServiceBean;
    }

    @Override
    public String getName() { return "user-registry"; }

    @Override
    public void getDescription() { System.out.println("user-registry: Registry new user."); }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        final String userLogin = terminalService.nextLine();
        System.out.println("Please enter your password: ");
        final String userPassword= terminalService.nextLine();
        if(userServiceBean.registry(userLogin, userPassword)) return;
        System.out.println("Sorry, login is busy...try again.");
    }

}
