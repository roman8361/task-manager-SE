package ru.kravchenko.tm;

import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.command.*;
import ru.kravchenko.tm.constant.CommandConstant;
import ru.kravchenko.tm.service.ProjectServiceBean;
import ru.kravchenko.tm.service.TaskServiceBean;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Roman Kravchenko
 */

public class Bootstrap {

    private Map<String, AbstractCommand> commandListMap = new HashMap<>();

    private ProjectServiceBean projectServiceBean = new ProjectServiceBean();

    private TaskServiceBean taskServiceBean = new TaskServiceBean(projectServiceBean);

    void init() {
        initCommandList();
        System.out.println("*** WELCOME TO TASK MANAGER ***");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter command (help: Show all command) :");
            String userInput = scanner.next();

            if (commandListMap.containsKey(userInput)) commandListMap.get(userInput).execute();

            if (!commandListMap.containsKey(userInput)) System.out.println("Not correct command, please try again");
        }
    }

    private void initCommandList() {
        commandListMap.put(CommandConstant.HELP, new ReferenceCommand());
        commandListMap.put(CommandConstant.PROJECT_CREATE, new ProjectCreateCommand(projectServiceBean));
        commandListMap.put(CommandConstant.PROJECT_LIST, new ProjectReadCommand(projectServiceBean));
        commandListMap.put(CommandConstant.PROJECT_REMOVE, new ProjectRemoveCommand(projectServiceBean));
        commandListMap.put(CommandConstant.PROJECT_CLEAR, new ProjectClearCommand(projectServiceBean));
        commandListMap.put(CommandConstant.PROJECT_UPDATE, new ProjectUpdateCommand(projectServiceBean));
        commandListMap.put(CommandConstant.TASK_CREATE, new TaskCreateCommand(taskServiceBean));
        commandListMap.put(CommandConstant.TASK_LIST, new TaskReadCommand(taskServiceBean));
        commandListMap.put(CommandConstant.TASK_REMOVE, new TaskClearCommand(taskServiceBean));
        commandListMap.put(CommandConstant.TASK_UPDATE, new TaskUpdateCommand(taskServiceBean));
        commandListMap.put(CommandConstant.EXIT, new ExitCommand());
    }

}


