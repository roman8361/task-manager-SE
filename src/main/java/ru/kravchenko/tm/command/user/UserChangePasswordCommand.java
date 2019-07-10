package ru.kravchenko.tm.command.user;

import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.api.service.IUserService;

/**
 * @author Roman Kravchenko
 */

public class UserChangePasswordCommand extends AbstractCommand {

    @NotNull
    private String userLogin;

    @Override
    public String getName() { return "user-change-password"; }

    @Override
    public void getDescription() {
        System.out.println("user-change-password: Change user password.");
    }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        userLogin = terminalService.nextLine();
        @NotNull final IUserService userServiceBean = serviceLocator.getUserService();
        if (userServiceBean.existsLoginBase(userLogin)){
            changePassword();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void changePassword() {
        System.out.println("Please enter old password: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String oldPassword = terminalService.nextLine();
        @NotNull final IUserService userServiceBean = serviceLocator.getUserService();
        if (userServiceBean.check(userLogin, DigestUtils.md5Hex(oldPassword))) {
            System.out.println("Please enter new password: ");
            final @NotNull String newPassword = terminalService.nextLine();
            userServiceBean.changePasswordUser(userLogin, DigestUtils.md5Hex(newPassword));
            System.out.println("New password is add");
            return;
        }
        System.out.println("Old password is not correct");
    }

}
