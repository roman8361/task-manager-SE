package ru.kravchenko.tm;

import lombok.NonNull;
import lombok.SneakyThrows;
import ru.kravchenko.tm.bootstrap.Bootstrap;
import ru.kravchenko.tm.command.additional.AboutCommand;
import ru.kravchenko.tm.command.additional.ExitCommand;
import ru.kravchenko.tm.command.additional.ReferenceCommand;
import ru.kravchenko.tm.command.project.*;
import ru.kravchenko.tm.command.task.*;
import ru.kravchenko.tm.command.user.*;

/**
 * @author Roman Kravchenko
 */

public class App {

    private static final Class[] CLASSES = {

            AboutCommand.class, ExitCommand.class, ReferenceCommand.class,

            ProjectAddToUserCommand.class, ProjectClearCommand.class, ProjectCreateCommand.class,
            ProjectReadCommand.class, ProjectRemoveCommand.class, ProjectUpdateCommand.class,
            ProjectUpdateStatusCommand.class, ProjectSearchCommand.class, ProjectDumpCommand.class,
            ProjectLoadCommand.class,

            TaskClearCommand.class, TaskCreateCommand.class, TaskReadCommand.class,
            TaskUpdateCommand.class, TaskUpdateStatusCommand.class, TaskDumpCommand.class,
            TaskLoadCommand.class,

            UserAuthorizationCommand.class, UserChangePasswordCommand.class, UserChangeProfileCommand.class,
            UserLogoutCommand.class, UserRegistryCommand.class, UserShowDateBaseCommand.class,
            UserShowLoginBaseCommand.class
    };

    @SneakyThrows
    public static void main(String[] args) {
        @NonNull final Bootstrap bootstrap = new Bootstrap();
        bootstrap.init(CLASSES);
    }

}
