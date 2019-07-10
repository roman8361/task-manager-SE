package ru.kravchenko.tm.endpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.endpoint.IProjectEndpoint;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.exception.AccessForbiddenException;
import ru.kravchenko.tm.model.dto.ProjectDTO;
import ru.kravchenko.tm.model.dto.SessionDTO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Collection;

/**
 * @author Roman Kravchenko
 */

@WebService
@NoArgsConstructor
public class ProjectEndpoint implements IProjectEndpoint {

    @NotNull
    private IServiceLocator serviceLocator;

    public ProjectEndpoint(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    public void editProject(@NotNull SessionDTO sessionDTO,
                            @NotNull String projectId,
                            @WebParam(name = "name") @NotNull final String name,
                            @WebParam(name = "description") @NotNull final String description) throws AccessForbiddenException {
        serviceLocator.getProjectService().updateProject(projectId, name, description, sessionDTO);
        System.out.println("PROJECT EDIT");
    }

    @Override
    @WebMethod
    public void createProject(@WebParam(name = "sessionDTO") @NotNull final SessionDTO sessionDTO,
                              @WebParam(name = "name") @NotNull final String name,
                              @WebParam(name = "description") @NotNull final String description) throws AccessForbiddenException {
        serviceLocator.getProjectService().createProject(sessionDTO, name, description);
        System.out.println("PROJECT CREATE");
    }

    @Override
    public void removeProject(@WebParam(name = "sessionDTO") @NotNull final SessionDTO sessionDTO,
                              @WebParam(name = "projectId") @NotNull final String projectId) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(sessionDTO);
        serviceLocator.getProjectService().removeById(projectId);
    }

    @Override
    public ProjectDTO findOneProject(@NotNull final SessionDTO sessionDTO,
                                     @NotNull final String projectId) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(sessionDTO);
        return serviceLocator.getProjectService().findById(projectId);
    }

    @Override
    @WebMethod
    public void removeAllProject(@WebParam(name = "sessionDTO") @NotNull final SessionDTO sessionDTO) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(sessionDTO);
        serviceLocator.getProjectService().removeAllProjectByUserId(sessionDTO.getUserId());
    }

    @Override
    @WebMethod
    public Collection<ProjectDTO> showAllProject(@WebParam(name = "sessionDTO") @NotNull final SessionDTO sessionDTO) throws AccessForbiddenException {
        final Collection<ProjectDTO> result = serviceLocator.getProjectService().findAllProjectByUserId(sessionDTO.getUserId());
        return result;
    }

}
