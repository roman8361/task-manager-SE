package ru.kravchenko.tm.bootstrap;

import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.command.additional.ExitCommand;
import ru.kravchenko.tm.command.additional.ReferenceCommand;
import ru.kravchenko.tm.command.project.*;
import ru.kravchenko.tm.command.task.TaskClearCommand;
import ru.kravchenko.tm.command.task.TaskCreateCommand;
import ru.kravchenko.tm.command.task.TaskReadCommand;
import ru.kravchenko.tm.command.task.TaskUpdateCommand;
import ru.kravchenko.tm.command.user.*;
import ru.kravchenko.tm.service.ServiceLocatorBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

public class Bootstrap {

    private IServiceLocator serviceLocator = new ServiceLocatorBean();

    private final ITerminalService terminalService = serviceLocator.getTerminalService();

    private final Map<String, AbstractCommand> commandListMap = new HashMap<>();

    public void init() {
        initCommandList();
        System.out.println("*** WELCOME TO TASK MANAGER ***");
        while (true) {
            System.out.println("Please enter command (help: Show all command): ");
            String userInput = terminalService.nextLine();
            if (commandListMap.containsKey(userInput)) commandListMap.get(userInput).execute();
            if (!commandListMap.containsKey(userInput)) System.out.println("Not correct command, please try again");
        }
    }

    private void initCommandList() {
        registry(new ReferenceCommand(serviceLocator));
        registry(new ExitCommand(serviceLocator));
        registry(new ProjectAddToUser(serviceLocator));
        registry(new ProjectClearCommand(serviceLocator));
        registry(new ProjectCreateCommand(serviceLocator));
        registry(new ProjectReadCommand(serviceLocator));
        registry(new ProjectRemoveCommand(serviceLocator));
        registry(new ProjectUpdateCommand(serviceLocator));
        registry(new TaskClearCommand(serviceLocator));
        registry(new TaskCreateCommand(serviceLocator));
        registry(new TaskReadCommand(serviceLocator));
        registry(new TaskUpdateCommand(serviceLocator));
        registry(new UserAuthorizationCommand(serviceLocator));
        registry(new UserChangePasswordCommand(serviceLocator));
        registry(new UserChangeProfileCommand(serviceLocator));
        registry(new UserLogoutCommand(serviceLocator));
        registry(new UserRegistryCommand(serviceLocator));
        registry(new UserShowDateBaseCommand(serviceLocator));
        registry(new UserShowLoginBaseCommand(serviceLocator));
    }

    private void registry(final AbstractCommand abstractCommand) {
        commandListMap.put(abstractCommand.getName(), abstractCommand);
    }

}


