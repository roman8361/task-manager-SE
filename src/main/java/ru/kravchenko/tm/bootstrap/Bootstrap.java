package ru.kravchenko.tm.bootstrap;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.exception.UserNotCorrectInputException;
import ru.kravchenko.tm.service.LocatorServiceBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class Bootstrap {

    @NotNull private IServiceLocator serviceLocator = new LocatorServiceBean();

    @NotNull private final ITerminalService terminalService = serviceLocator.getTerminalService();

    @Nullable private final Map<String, AbstractCommand> commandListMap = new HashMap<>();

    public void init(@NotNull final Class[] arrayCommands) throws IllegalAccessException, InstantiationException, UserNotCorrectInputException {
        for (@NotNull final Class command : arrayCommands) {
            if (command.getSuperclass().equals(AbstractCommand.class)) {
                AbstractCommand abstractCommand = (AbstractCommand) command.newInstance();
                abstractCommand.setServiceLocator(serviceLocator);
                commandListMap.put(abstractCommand.getName(), abstractCommand);
            }
        }

        System.out.println("*** WELCOME TO TASK MANAGER ***");

        while (true) {
            System.out.println("Please enter command (help: Show all command): ");
            @NotNull final String userInput = terminalService.nextLine();
            if (commandListMap.containsKey(userInput)) commandListMap.get(userInput).execute();
            if (!commandListMap.containsKey(userInput)) System.out.println("Not correct command, please try again");
        }
    }

}


