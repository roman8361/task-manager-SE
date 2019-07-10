package ru.kravchenko.tm.bootstrap;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.IEndpointServiceLocator;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.SessionNotFoundException_Exception;
import ru.kravchenko.tm.endpoint.UserNotFoundException_Exception;
import ru.kravchenko.tm.service.EndpointServiceLocator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

public class Bootstrap {

    @NotNull
    private final IEndpointServiceLocator endpointServiceLocator = new EndpointServiceLocator();

    @Nullable
    private final Map<String, AbstractCommand> commandListMap = new HashMap<>();

    public void init(@NotNull final Class[] arrayCommands) throws IllegalAccessException, InstantiationException, AccessForbiddenException_Exception, UserNotFoundException_Exception, SessionNotFoundException_Exception {
        for (@NotNull Class command : arrayCommands) {
            if (command.getSuperclass().equals(AbstractCommand.class)) {
                @NotNull final AbstractCommand abstractCommand = (AbstractCommand) command.newInstance();
                abstractCommand.setServiceLocator(endpointServiceLocator);
                commandListMap.put(abstractCommand.getName(), abstractCommand);
            }
        }

        System.out.println("*** WELCOME TO TASK MANAGER ***");

        while (true) {
            System.out.println("Please enter command (help: Show all command): ");
            @NotNull final String userInput = endpointServiceLocator.getTerminalService().nextLine();
            if (commandListMap.containsKey(userInput)) commandListMap.get(userInput).execute();
            if (!commandListMap.containsKey(userInput)) System.out.println("Not correct command, please try again");
        }
    }

}
