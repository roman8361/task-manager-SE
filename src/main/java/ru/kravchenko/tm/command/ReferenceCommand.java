package ru.kravchenko.tm.command;

import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.ProjectServiceBean;

/**
 * @author Roman Kravchenko
 */

public class ReferenceCommand extends AbstractCommand {

    private final ProjectServiceBean projectServiceBean = new ProjectServiceBean();

    @Override
    public String getName() { return "help"; }

    @Override
    public void getDescription() { System.out.println("help: Show all command."); }

    @Override
    public void execute() { projectServiceBean.showAllCommand(); }

}
