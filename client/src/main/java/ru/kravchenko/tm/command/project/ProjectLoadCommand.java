package ru.kravchenko.tm.command.project;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.ITerminalService;
import ru.kravchenko.tm.endpoint.AccessForbiddenException_Exception;
import ru.kravchenko.tm.endpoint.ProjectEndpoint;
import ru.kravchenko.tm.endpoint.Session;

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
    public void execute() throws AccessForbiddenException_Exception {
        @NotNull final ProjectEndpoint projectEndpoint = serviceLocator.getProjectEndpoint();
        @NotNull final Session session = serviceLocator.getSession();
        try {
            serviceLocator.getSessionEndpoint().validateSession(session);
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("***Project Load Command***");
        System.out.println("You can load date (1 - serializable; 2-1 XML JAXB; 2-2 JSON JAXB)");
        System.out.println("3-1 XML FasterXML; 3-2 JSON FasterXML) Please enter number: ");
        @NotNull final ITerminalService terminalService = serviceLocator.getTerminalService();
        @NotNull final String userSelect = terminalService.nextLine();
        switch (userSelect) {
            case "1":
                projectEndpoint.loadDateSerializ(session);
                break;
            case "2-1":
                projectEndpoint.loadDateJAXBtoMapFromXML(session);
                break;
            case "2-2":
                projectEndpoint.loadDateJAXBtoMapFromJson(session);
                break;

//            case "3-1":
//                projectEndpoint.loadDateOMtoXML();
//                break;

            case "3-2":
                projectEndpoint.loadDateOMtoJson(session);
                break;
            default:
                System.out.println("Unidentified command, please try again");
        }
        return;
    }

}



