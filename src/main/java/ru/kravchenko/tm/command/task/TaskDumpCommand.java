package ru.kravchenko.tm.command.task;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.ITaskService;
import ru.kravchenko.tm.api.service.ITerminalService;

/**
 * @author Roman Kravchenko
 */
public class TaskDumpCommand extends AbstractCommand {

    @Override
    public String getName() { return "task-dump"; }

    @Override
    public void getDescription() {
        System.out.println("task-dump: Save task date form repository in disk");
    }

    @Override
    public void execute() {
        System.out.println("You can save date (1 - serializable; 2-1 XML JAXB; 2-2 JSON JAXB)");
        System.out.println("3-1 XML FasterXML; 3-2 JSON FasterXML) Please enter number: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String userSelect = terminalService.nextLine();
        @NotNull final ITaskService taskService = serviceLocator.getTaskService();

        switch (userSelect) {
            case "1":
                taskService.saveDateSerializ();
                break;
            case "2-1":
                taskService.saveDateJAXBtoXML();
                break;
            case "2-2":
                taskService.saveDateJAXBtoJson();
                break;

            case "3-1":
                taskService.saveDateOMtoXML();
                break;

            case "3-2":
                taskService.saveDateOMtoJson();
                break;

            default:
                System.out.println("Unidentified command, please try again");
        }
        return;
    }

    }


