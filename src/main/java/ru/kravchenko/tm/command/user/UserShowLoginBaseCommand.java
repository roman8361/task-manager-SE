package ru.kravchenko.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.UserServiceBean;

/**
 * @author Roman Kravchenko
 */
public class UserShowLoginBaseCommand extends AbstractCommand {

    @NotNull
    private UserServiceBean userServiceBean;

    public UserShowLoginBaseCommand(@NotNull UserServiceBean userServiceBean) {
        this.userServiceBean = userServiceBean;
    }

    @Override
    public String getName() {
        return "user-all-show-online";
    }

    @Override
    public void getDescription() {
        System.out.println("Show all users from on line");
    }

    @Override
    public void execute() { userServiceBean.showAllUsersLoginBase(); }

}
