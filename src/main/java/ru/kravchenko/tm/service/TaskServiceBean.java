package ru.kravchenko.tm.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.reposiroty.IProjectRepository;
import ru.kravchenko.tm.api.reposiroty.ITaskRepository;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.api.service.ITaskService;
import ru.kravchenko.tm.api.service.ITerminalService;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.Task;

/**
 * @author Roman Kravchenko
 */

public class TaskServiceBean implements ITaskService {

    @NotNull
    private final IServiceLocator serviceLocator;

    @NotNull
    private final ITerminalService terminalService1;

    @NotNull
    private ITaskRepository taskRepositoryBean;

    @NotNull
    private IProjectRepository projectRepository;

    public TaskServiceBean(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
        this.terminalService1 = serviceLocator.getTerminalService();
        this.projectRepository = serviceLocator.getProjectRepository();
        this.taskRepositoryBean = serviceLocator.getTaskRepository();
    }

    public void mergeTask(@Nullable final String projectId,
                          @Nullable final String taskName,
                          @Nullable final String taskDescription) {
        final @NotNull Project project = projectRepository.findOne(projectId);
        final @NotNull Task task = new Task();
        task.setName(taskName);
        task.setDescription(taskDescription);
        task.setProject(project);
        taskRepositoryBean.addTask(task.getId(),task);
        System.out.println("Task is add to project");
    }

    @Override
    public String getIdFromUser() {
        System.out.println("Please enter id task: ");
        final @NotNull String idTask = terminalService1.nextLine();
        return idTask;
    }

    @Override
    public void updateTask(@Nullable final String taskId,
                           @Nullable final String taskName,
                           @Nullable final String taskDescription) {
        final @NotNull Task task = taskRepositoryBean.findOneId(taskId);
        task.setName(taskName);
        task.setDescription(taskDescription);
        taskRepositoryBean.addTask(task.getId(),task);
        System.out.println("Task is update to project");
    }

}
