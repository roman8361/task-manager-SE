package ru.kravchenko.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.repository.UserRepositoryBean;

/**
 * @author Roman Kravchenko
 */
public class UserShowLoginBaseCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "user-all-show-online";
    }

    @Override
    public void getDescription() {
        System.out.println("Show all users from on line");
    }

    @Override
    public void execute() {
        final @NotNull UserRepositoryBean userRepositoryBean = (UserRepositoryBean) serviceLocator.getUserRepository();
        userRepositoryBean.showAllUsers(userRepositoryBean.getUsersLoginBase());
    }

}
