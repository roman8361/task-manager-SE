package ru.kravchenko.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.UserServiceBean;

/**
 * @author Roman Kravchenko
 */
public class UserShowDateBaseCommand extends AbstractCommand {

    @NotNull
    private UserServiceBean userServiceBean;

    public UserShowDateBaseCommand(@NotNull UserServiceBean userServiceBean) {

        this.userServiceBean = userServiceBean;
    }

    @Override
    public String getName() {
        return "user-all-show";
    }

    @Override
    public void getDescription() {
        System.out.println("Show all users from MAP");
    }

    @Override
    public void execute() {
        userServiceBean.showAllUsersBaseDate();
    }


}
