package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IProjectService;
import ru.kravchenko.tm.api.service.ITerminalService;

/**
 * @author Roman Kravchenko
 */

public class ProjectDumpCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "project-dump";
    }

    @Override
    public void getDescription() {
        System.out.println("project-dump: Save project date form repository in disk");
    }

    @Override
    public void execute() {
        System.out.println("You can save date (1 - serializable; 2-1 XML JAXB; 2-2 JSON JAXB)");
        System.out.println("3-1 XML FasterXML; 3-2 JSON FasterXML) Please enter number: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String userSelect = terminalService.nextLine();
        @NotNull final IProjectService projectService = serviceLocator.getProjectService();

        switch (userSelect) {
            case "1":
                projectService.saveDateSerializ();
                break;
            case "2-1":
                projectService.saveDateJAXBtoXML();
                break;
            case "2-2":
                projectService.saveDateJAXBtoJson();
                break;

            case "3-1":
                projectService.saveDateOMtoXML();
                break;

            case "3-2":
                projectService.saveDateOMtoJson();
                break;

            default:
                System.out.println("Unidentified command, please try again");
        }
        return;
    }

}
