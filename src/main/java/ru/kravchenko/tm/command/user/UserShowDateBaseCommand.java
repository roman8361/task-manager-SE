package ru.kravchenko.tm.command.user;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.repository.UserRepositoryBean;

/**
 * @author Roman Kravchenko
 */
public class UserShowDateBaseCommand extends AbstractCommand {

    @NotNull
    private final IServiceLocator serviceLocator;

    @NotNull
    private final UserRepositoryBean userRepositoryBean;

    public UserShowDateBaseCommand(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        this.userRepositoryBean = (UserRepositoryBean) serviceLocator.getUserRepository();
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
        userRepositoryBean.showAllUsers(userRepositoryBean.getUsersBaseDate());
    }

}
