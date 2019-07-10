package ru.kravchenko.tm.api.endpoint;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.exception.AccessForbiddenException;
import ru.kravchenko.tm.model.dto.SessionDTO;
import ru.kravchenko.tm.model.dto.TaskDTO;

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
    void createTask(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                    @WebParam(name = "projectId") @NotNull final String projectId,
                    @WebParam(name = "name") @NotNull final String name,
                    @WebParam(name = "description") @NotNull final String description
    ) throws AccessForbiddenException;

    @WebMethod
    void removeTask(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                    @WebParam(name = "id") @NotNull final String id) throws AccessForbiddenException;

    @WebMethod
    TaskDTO findOneTask(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO,
                        @WebParam(name = "id") @NotNull final String id) throws AccessForbiddenException;

    @WebMethod
    Collection<TaskDTO> getAllTaskByUserId(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws AccessForbiddenException;

    @WebMethod
    void removeAllTaskByUserId(@WebParam(name = "session") @NotNull final SessionDTO sessionDTO) throws AccessForbiddenException;

}
