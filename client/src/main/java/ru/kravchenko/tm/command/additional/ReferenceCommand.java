package ru.kravchenko.tm.command.additional;

import ru.kravchenko.tm.api.AbstractCommand;

/**
 * @author Roman Kravchenko
 */

public class ReferenceCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public void getDescription() {
        System.out.println("help: Show all command.");
    }

    @Override
    public void execute() {
        System.out.println("help: Show all command.");
        System.out.println("user-registry: Registry new user.");
        System.out.println("user-authorization: Login user.");
        System.out.println("user-logout: Logout user.");
        System.out.println("project-clear: Remove all projects.");
        System.out.println("project-create: Create new project.");
        System.out.println("project-list: Show all project.");
        System.out.println("project-update-status: Update project status by id.");
        System.out.println("project-remove: Remove selected project by id.");
        System.out.println("project-edit: Edit selected project by id.");
        System.out.println("project-search: Search project by name or description or id project.");
        System.out.println("task-clear: Remove all tasks.");
        System.out.println("task-create: Create new task.");
        System.out.println("task-list: Show all tasks.");
        System.out.println("task-update-status: Update project status by id.");
        System.out.println("exit: Exit");
    }

}