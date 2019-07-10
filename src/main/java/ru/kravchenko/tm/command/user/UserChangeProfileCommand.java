package ru.kravchenko.tm.command.user;

import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;

/**
 * @author Roman Kravchenko
 */
public class UserChangeProfileCommand extends AbstractCommand {

    @Nullable
    private String userLogin;

    @Override
    public String getName() { return "user-change-profile"; }

    @Override
    public void getDescription() {
        System.out.println("user-change-profile: Change profile user.");
    }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        final @NotNull ITerminalService terminalService = serviceLocator.getTerminalService();
        userLogin = terminalService.nextLine();
        final @NotNull IUserService userServiceBean = serviceLocator.getUserService();
        if (userServiceBean.existsLoginBase(userLogin)){
            changeProfileUser();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void changeProfileUser() {
        System.out.println("Please enter password: ");
        final @NotNull ITerminalService terminalService = serviceLocator.getTerminalService();
        final @NotNull String oldPassword = terminalService.nextLine();
        final @NotNull  IUserService userServiceBean = serviceLocator.getUserService();
        if (userServiceBean.check(userLogin, DigestUtils.md5Hex(oldPassword))){
            System.out.println("Please enter new login: ");
            final @NotNull String newLogin = terminalService.nextLine();
            System.out.println("Please enter new password: ");
            final @NotNull String newPassword = terminalService.nextLine();
            userServiceBean.changeProfileUser(userLogin, newLogin, newPassword);
            return;
        }
        System.out.println("Profile is change");
    }

}
