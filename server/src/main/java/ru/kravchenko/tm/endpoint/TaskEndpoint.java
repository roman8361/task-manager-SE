package ru.kravchenko.tm.endpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.endpoint.ITaskEndpoint;
import ru.kravchenko.tm.api.service.IServiceLocator;
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
@NoArgsConstructor
public class TaskEndpoint implements ITaskEndpoint {

    private IServiceLocator serviceLocator;

    public TaskEndpoint(IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    @WebMethod
    public void createTask(@WebParam(name = "sessionDTO") @NotNull final SessionDTO sessionDTO,
                           @WebParam(name = "projectId") @NotNull final String projectId,
                           @WebParam(name = "name") @NotNull final String name,
                           @WebParam(name = "description") @NotNull final String description) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(sessionDTO);
        serviceLocator.getTaskService().mergeTask(projectId, name, description, sessionDTO.getUserId());
        System.out.println("TASK CREATE");
    }

    @Override
    @WebMethod
    public void removeTask(@NotNull final SessionDTO sessionDTO,
                           @NotNull final String id) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(sessionDTO);
        serviceLocator.getTaskService().removeById(id);
    }

    @Override
    @WebMethod
    public TaskDTO findOneTask(@NotNull final SessionDTO sessionDTO,
                               @NotNull final String id) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(sessionDTO);
        return serviceLocator.getTaskService().findById(id);
    }

    @Override
    public Collection<TaskDTO> getAllTaskByUserId(@NotNull final SessionDTO sessionDTO) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(sessionDTO);
        return serviceLocator.getTaskService().findAllTaskByUserId(sessionDTO.getUserId());
    }

    @Override
    public void removeAllTaskByUserId(@NotNull final SessionDTO sessionDTO) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(sessionDTO);
        serviceLocator.getTaskService().removeAllTaskByUserId(sessionDTO.getUserId());
    }

}
