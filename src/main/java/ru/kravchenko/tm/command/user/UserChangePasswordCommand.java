package ru.kravchenko.tm.command.user;

import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.UserServiceBean;
import ru.kravchenko.tm.utils.TerminalService;

/**
 * @author Roman Kravchenko
 */

public class UserChangePasswordCommand extends AbstractCommand {

    private String userLogin;

    private TerminalService terminalService = new TerminalService();

    @NotNull
    private UserServiceBean userServiceBean;

    public UserChangePasswordCommand(@NotNull UserServiceBean userServiceBean) {
        this.userServiceBean = userServiceBean;
    }

    @Override
    public String getName() { return "user-change-password"; }

    @Override
    public void getDescription() {
        System.out.println("user-change-password: Change user password.");
    }

    @Override
    public void execute() {
        System.out.println("Please enter your login: ");
        userLogin = terminalService.nextLine();
        if (userServiceBean.existsLoginBase(userLogin)){
            changePassword();
            return;
        }
        System.out.println("This command is available only to authorized users. Please login.");
    }

    private void changePassword() {
        System.out.println("Please enter old password: ");
        final String oldPassword = terminalService.nextLine();
        if (userServiceBean.check(userLogin, DigestUtils.md5Hex(oldPassword))) {
            System.out.println("Please enter new password: ");
            final String newPassword = terminalService.nextLine();
            userServiceBean.changePasswordUser(userLogin, DigestUtils.md5Hex(newPassword));
            System.out.println("New password is add");
            return;
        }
        System.out.println("Old password is not correct");
    }

}
