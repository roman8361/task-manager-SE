package ru.kravchenko.tm.command.additional;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.AbstractCommand;
import ru.kravchenko.tm.api.service.IProjectService;
import ru.kravchenko.tm.api.service.IServiceLocator;

/**
 * @author Roman Kravchenko
 */

public class ExitCommand extends AbstractCommand {

    @NotNull
    private final IServiceLocator serviceLocator;

    public ExitCommand(final @NotNull IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public String getName() { return "exit"; }

    @Override
    public void getDescription() { System.out.println("exit: Exit"); }

    @Override
    public void execute() {
        final IProjectService projectServiceBean = serviceLocator.getProjectService();
        projectServiceBean.exit(); }

}
