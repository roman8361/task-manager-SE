package ru.kravchenko.tm.endpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.endpoint.ITaskEndpoint;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.entity.Task;
import ru.kravchenko.tm.exception.AccessForbiddenException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Collection;

/**
 * @author Roman Kravchenko
 */

@WebService
@NoArgsConstructor
public class TaskEndpoint implements ITaskEndpoint {

    private IServiceLocator serviceLocator;

    public TaskEndpoint(IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    @WebMethod
    public void createTask(@WebParam(name = "session") @NotNull final Session session,
                           @WebParam(name = "projectId") @NotNull final String projectId,
                           @WebParam(name = "name") @NotNull final String name,
                           @WebParam(name = "description") @NotNull final String description) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getTaskService().mergeTask(projectId, name, description, session.getUserId());
        System.out.println("TASK CREATE");
        assert session.getUserId() != null;
    }

    @Override
    @WebMethod
    public void removeTask(@NotNull final Session session,
                           @NotNull final String id) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getTaskRepository().removeById(id);
    }

    @Override
    @WebMethod
    public Task findOneTask(@NotNull final Session session,
                            @NotNull final String id) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        return serviceLocator.getTaskRepository().findById(id);
    }

    @Override
    public Collection<Task> getAllTaskByUserId(@NotNull final Session session,
                                               @NotNull final String userId) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        return serviceLocator.getTaskRepository().findAllTaskByUserId(userId);
    }

    @Override
    public void removeAllTaskByUserId(@NotNull final Session session) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getTaskRepository().removeAllTaskByUserId(session.getUserId());
    }


}
