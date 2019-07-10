package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IProjectService;
import ru.kravchenko.tm.api.service.ITerminalService;

/**
 * @author Roman Kravchenko
 */


public class ProjectLoadCommand extends AbstractCommand {
    @Override
    public String getName() { return "project-load"; }

    @Override
    public void getDescription() {
        System.out.println("project-load: Load project form disk to repository");
    }

    @Override
    public void execute() {
        System.out.println("You can load date (1 - serializable; 2-1 XML JAXB; 2-2 JSON JAXB)");
        System.out.println("3-1 XML FasterXML; 3-2 JSON FasterXML) Please enter number: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String userSelect = terminalService.nextLine();
        @NotNull final IProjectService projectService = serviceLocator.getProjectService() ;
        switch (userSelect) {
            case "1":
                projectService.loadDateSerializ();
                break;
            case "2-1":
                projectService.loadDateJAXBtoMapFromXML();
                break;
            case "2-2":
                projectService.loadDateJAXBtoMapFromJson();
                break;
            case "3-1":
                projectService.loadDateOMtoXML();
                break;
            case "3-2":
                projectService.loadDateOMtoJson();
                break;
            default:
                System.out.println("Unidentified command, please try again");
        }
        return;
    }

}



