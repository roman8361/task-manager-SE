package ru.kravchenko.tm;

import lombok.NonNull;
import lombok.SneakyThrows;
import ru.kravchenko.tm.bootstrap.Bootstrap;
import ru.kravchenko.tm.command.additional.AboutCommand;
import ru.kravchenko.tm.command.additional.ExitCommand;
import ru.kravchenko.tm.command.additional.ReferenceCommand;
import ru.kravchenko.tm.command.project.*;
import ru.kravchenko.tm.command.task.TaskClearCommand;
import ru.kravchenko.tm.command.task.TaskCreateCommand;
import ru.kravchenko.tm.command.task.TaskReadCommand;
import ru.kravchenko.tm.command.user.UserAuthorizationCommand;
import ru.kravchenko.tm.command.user.UserLogoutCommand;
import ru.kravchenko.tm.command.user.UserRegistryCommand;
import ru.kravchenko.tm.endpoint.RegistryUser;

/**
 * @author Roman Kravchenko
 */

public class App {

    private static final Class[] CLASSES = {

            AboutCommand.class, ExitCommand.class, ReferenceCommand.class,

            ProjectClearCommand.class, ProjectCreateCommand.class, ProjectSearchCommand.class,
            ProjectReadCommand.class, ProjectRemoveCommand.class, ProjectEditComman.class,

            TaskClearCommand.class, TaskCreateCommand.class, TaskReadCommand.class,

            UserAuthorizationCommand.class, UserLogoutCommand.class, UserRegistryCommand.class};

    @SneakyThrows
    public static void main(String[] args) {
        @NonNull final Bootstrap bootstrap = new Bootstrap();
        bootstrap.init(CLASSES);
    }

}
