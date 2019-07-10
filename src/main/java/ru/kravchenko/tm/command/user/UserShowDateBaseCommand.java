package ru.kravchenko.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.repository.UserRepositoryBean;

/**
 * @author Roman Kravchenko
 */

public class UserShowDateBaseCommand extends AbstractCommand {

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
        @NotNull final UserRepositoryBean userRepositoryBean = (UserRepositoryBean) serviceLocator.getUserRepository();
        userRepositoryBean.showAllUsers(userRepositoryBean.getUsersBaseDate());
    }

}
