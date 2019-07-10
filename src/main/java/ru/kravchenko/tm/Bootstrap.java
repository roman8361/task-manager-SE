package ru.kravchenko.tm;

import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.command.additional.ExitCommand;
import ru.kravchenko.tm.command.additional.ReferenceCommand;
import ru.kravchenko.tm.command.project.*;
import ru.kravchenko.tm.command.task.TaskClearCommand;
import ru.kravchenko.tm.command.task.TaskCreateCommand;
import ru.kravchenko.tm.command.task.TaskReadCommand;
import ru.kravchenko.tm.command.task.TaskUpdateCommand;
import ru.kravchenko.tm.command.user.*;
import ru.kravchenko.tm.service.ProjectServiceBean;
import ru.kravchenko.tm.service.TaskServiceBean;
import ru.kravchenko.tm.service.UserServiceBean;
import ru.kravchenko.tm.utils.TerminalService;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

public class Bootstrap {

    private TerminalService terminalService = new TerminalService();

    private UserServiceBean userServiceBean = new UserServiceBean();

    private Map<String, AbstractCommand> commandListMap = new HashMap<>();

    private ProjectServiceBean projectServiceBean = new ProjectServiceBean(userServiceBean);

    private TaskServiceBean taskServiceBean = new TaskServiceBean(projectServiceBean);

    void init() {
        initCommandList();
        System.out.println("*** WELCOME TO TASK MANAGER ***");
        while (true) {
            System.out.println("Please enter command (help: Show all command) :");
            String userInput = terminalService.nextLine();
            if (commandListMap.containsKey(userInput)) commandListMap.get(userInput).execute();
            if (!commandListMap.containsKey(userInput)) System.out.println("Not correct command, please try again");
        }
    }

    private void initCommandList() {
        registry(new ReferenceCommand(projectServiceBean));
        registry(new ExitCommand(projectServiceBean));
        registry(new ProjectAddToUser(userServiceBean, projectServiceBean));
        registry(new ProjectClearCommand(userServiceBean, projectServiceBean));
        registry(new ProjectCreateCommand(userServiceBean, projectServiceBean));
        registry(new ProjectReadCommand(userServiceBean, projectServiceBean));
        registry(new ProjectRemoveCommand(userServiceBean, projectServiceBean));
        registry(new ProjectUpdateCommand(userServiceBean, projectServiceBean));
        registry(new TaskClearCommand(userServiceBean, taskServiceBean));
        registry(new TaskCreateCommand(userServiceBean, taskServiceBean));
        registry(new TaskReadCommand(userServiceBean, taskServiceBean));
        registry(new TaskUpdateCommand(userServiceBean, taskServiceBean));
        registry(new UserAuthorizationCommand(userServiceBean));
        registry(new UserChangePasswordCommand(userServiceBean));
        registry(new UserChangeProfileCommand(userServiceBean));
        registry(new UserLogoutCommand(userServiceBean));
        registry(new UserRegistryCommand(userServiceBean));
        registry(new UserShowDateBaseCommand(userServiceBean));
        registry(new UserShowLoginBaseCommand(userServiceBean));
    }

    private void registry(final AbstractCommand abstractCommand) {
        commandListMap.put(abstractCommand.getName(), abstractCommand);
    }

}


