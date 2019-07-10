package ru.kravchenko.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
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
public interface ITaskEndpoint {

    @WebMethod
    void createTask(@WebParam(name = "session") @NotNull final Session session,
                    @WebParam(name = "projectId") @NotNull final String projectId,
                    @WebParam(name = "name") @NotNull final String name,
                    @WebParam(name = "description") @NotNull final String description
    ) throws AccessForbiddenException;

    @WebMethod
    void removeTask(@WebParam(name = "session") @NotNull final Session session,
                    @WebParam(name = "id") @NotNull final String id) throws AccessForbiddenException;


    @WebMethod
    Task findOneTask(@WebParam(name = "session") @NotNull final Session session,
                     @WebParam(name = "id") @NotNull final String id) throws AccessForbiddenException;

    @WebMethod
    Collection<Task> getAllTaskByUserId(@WebParam(name = "session") @NotNull final Session session,
                                        @WebParam(name = "userId") @NotNull final String userId) throws AccessForbiddenException;

    @WebMethod
    void removeAllTaskByUserId(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException;

}
