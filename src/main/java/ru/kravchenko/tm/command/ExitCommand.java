package ru.kravchenko.tm.command;

import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.service.ProjectServiceBean;

/**
 * @author Roman Kravchenko
 */

public class ExitCommand extends AbstractCommand {

    private ProjectServiceBean projectServiceBean = new ProjectServiceBean();

    @Override
    public String getName() { return "exit"; }

    @Override
    public void getDescription() { System.out.println("exit: Exit"); }

    @Override
    public void execute() { projectServiceBean.exit(); }

}
