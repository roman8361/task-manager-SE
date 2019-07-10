package ru.kravchenko.tm.endpoint;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.kravchenko.tm.api.endpoint.IProjectEndpoint;
import ru.kravchenko.tm.api.service.IProjectService;
import ru.kravchenko.tm.api.service.ISessionService;
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
@Controller
public class ProjectEndpoint implements IProjectEndpoint {

    @NotNull
    @Autowired
    private IProjectService projectService;

    @NotNull
    @Autowired
    private ISessionService sessionService;

    @Override
    public void editProject(@NotNull SessionDTO sessionDTO,
                            @NotNull String projectId,
                            @WebParam(name = "name") @NotNull final String name,
                            @WebParam(name = "description") @NotNull final String description) throws AccessForbiddenException {
        projectService.updateProject(projectId, name, description, sessionDTO);
        System.out.println("PROJECT EDIT");
    }

    @Override
    @WebMethod
    public void createProject(@WebParam(name = "sessionDTO") @NotNull final SessionDTO sessionDTO,
                              @WebParam(name = "name") @NotNull final String name,
                              @WebParam(name = "description") @NotNull final String description) throws AccessForbiddenException {
        projectService.createProject(sessionDTO, name, description);
        System.out.println("PROJECT CREATE");
    }

    @Override
    public void removeProject(@WebParam(name = "sessionDTO") @NotNull final SessionDTO sessionDTO,
                              @WebParam(name = "projectId") @NotNull final String projectId) throws AccessForbiddenException {
        sessionService.validate(sessionDTO);
        projectService.removeById(projectId);
    }

    @Override
    public ProjectDTO findOneProject(@NotNull final SessionDTO sessionDTO,
                                     @NotNull final String projectId) throws AccessForbiddenException {
        sessionService.validate(sessionDTO);
        return projectService.findById(projectId);
    }

    @Override
    @WebMethod
    public void removeAllProject(@WebParam(name = "sessionDTO") @NotNull final SessionDTO sessionDTO) throws AccessForbiddenException {
        sessionService.validate(sessionDTO);
        projectService.removeAllProjectByUserId(sessionDTO.getUserId());
    }

    @Override
    @WebMethod
    public Collection<ProjectDTO> showAllProject(@WebParam(name = "sessionDTO") @NotNull final SessionDTO sessionDTO) throws AccessForbiddenException {
        final Collection<ProjectDTO> result = projectService.findAllProjectByUserId(sessionDTO.getUserId());
        return result;
    }

}
