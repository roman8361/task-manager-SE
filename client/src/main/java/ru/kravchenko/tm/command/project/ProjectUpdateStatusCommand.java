package ru.kravchenko.tm.command.project;

import ru.kravchenko.tm.api.AbstractCommand;

/**
 * @author Roman Kravchenko
 */

public class ProjectUpdateStatusCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "project-update-status";
    }

    @Override
    public void getDescription() {
        System.out.println("project-update-status: Update project status by id.");
    }

    @Override
    public void execute() {
    }

}
