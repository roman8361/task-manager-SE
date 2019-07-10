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
        serviceLocator.getTaskRepository().showAllTask(session.getUserId());
    }

    @Override
    @WebMethod
    public void removeTask(@NotNull Session session,
                           @NotNull String id) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);

    }

    @Override
    @WebMethod
    public Task findOneTask(@NotNull Session session,
                            @NotNull String id) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        return serviceLocator.getTaskRepository().findOneId(id);
    }

    @Override
    @WebMethod
    public Collection<Task> showAllTask(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        Collection<Task> result = serviceLocator.getTaskRepository().findAll(session.getUserId());
        return result;
    }

    @Override
    @WebMethod
    public void removeAllTask(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getTaskRepository().removeAllTask();
    }

}
