package ru.kravchenko.tm.endpoint;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.kravchenko.tm.api.endpoint.ITaskEndpoint;
import ru.kravchenko.tm.api.service.ISessionService;
import ru.kravchenko.tm.api.service.ITaskService;
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
@Controller
public class TaskEndpoint implements ITaskEndpoint {

    @NotNull
    @Autowired
    private ISessionService sessionService;

    @NotNull
    @Autowired
    private ITaskService taskService;

    @Override
    @WebMethod
    public void createTask(@WebParam(name = "sessionDTO") @NotNull final SessionDTO sessionDTO,
                           @WebParam(name = "projectId") @NotNull final String projectId,
                           @WebParam(name = "name") @NotNull final String name,
                           @WebParam(name = "description") @NotNull final String description) throws AccessForbiddenException {
        sessionService.validate(sessionDTO);
        taskService.mergeTask(projectId, name, description, sessionDTO.getUserId());
        System.out.println("TASK CREATE");
    }

    @Override
    @WebMethod
    public void removeTask(@NotNull final SessionDTO sessionDTO,
                           @NotNull final String id) throws AccessForbiddenException {
        sessionService.validate(sessionDTO);
        taskService.removeById(id);
    }

    @Override
    @WebMethod
    public TaskDTO findOneTask(@NotNull final SessionDTO sessionDTO,
                               @NotNull final String id) throws AccessForbiddenException {
        sessionService.validate(sessionDTO);
        return taskService.findById(id);
    }

    @Override
    public Collection<TaskDTO> getAllTaskByUserId(@NotNull final SessionDTO sessionDTO) throws AccessForbiddenException {
        sessionService.validate(sessionDTO);
        return taskService.findAllTaskByUserId(sessionDTO.getUserId());
    }

    @Override
    public void removeAllTaskByUserId(@NotNull final SessionDTO sessionDTO) throws AccessForbiddenException {
        sessionService.validate(sessionDTO);
        taskService.removeAllTaskByUserId(sessionDTO.getUserId());
    }

}
