package ru.kravchenko.tm.bootstrap;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.service.ServiceLocatorBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class Bootstrap {

    private IServiceLocator serviceLocator = new ServiceLocatorBean();

    private final @NotNull ITerminalService terminalService = serviceLocator.getTerminalService();

    private final @Nullable Map<String, AbstractCommand> commandListMap = new HashMap<>();

    public void init(final @NotNull Class[] arrayCommands) throws IllegalAccessException, InstantiationException {
        for (@NotNull Class command : arrayCommands) {
            if (command.getSuperclass().equals(AbstractCommand.class)) {
                AbstractCommand abstractCommand = (AbstractCommand) command.newInstance();
                abstractCommand.setServiceLocator(serviceLocator);
                commandListMap.put(abstractCommand.getName(), abstractCommand);
            }
        }

        System.out.println("*** WELCOME TO TASK MANAGER ***");

        while (true) {
            System.out.println("Please enter command (help: Show all command): ");
            final @NotNull String userInput = terminalService.nextLine();
            if (commandListMap.containsKey(userInput)) commandListMap.get(userInput).execute();
            if (!commandListMap.containsKey(userInput)) System.out.println("Not correct command, please try again");
        }
    }

}


