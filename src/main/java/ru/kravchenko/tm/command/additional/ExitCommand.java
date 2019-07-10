package ru.kravchenko.tm.command.additional;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IProjectService;

/**
 * @author Roman Kravchenko
 */

public class ExitCommand extends AbstractCommand {

    @Override
    public String getName() { return "exit"; }

    @Override
    public void getDescription() { System.out.println("exit: Exit"); }

    @Override
    public void execute() {
        @NotNull final IProjectService projectServiceBean = serviceLocator.getProjectService();
        projectServiceBean.exit(); }

}
