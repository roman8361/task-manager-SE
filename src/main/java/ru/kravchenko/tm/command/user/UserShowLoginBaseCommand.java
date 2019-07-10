package ru.kravchenko.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.repository.UserRepositoryBean;

/**
 * @author Roman Kravchenko
 */
public class UserShowLoginBaseCommand extends AbstractCommand {

    @NotNull
    private final IServiceLocator serviceLocator;
    @NotNull
    private final UserRepositoryBean userRepositoryBean;

    public UserShowLoginBaseCommand(final @NotNull IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        this.userRepositoryBean = (UserRepositoryBean) serviceLocator.getUserRepository();
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
    public void execute() {
        userRepositoryBean.showAllUsers(userRepositoryBean.getUsersLoginBase());
    }

}
