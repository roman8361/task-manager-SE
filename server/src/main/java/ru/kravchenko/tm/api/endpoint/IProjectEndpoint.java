package ru.kravchenko.tm.api.endpoint;


import org.jetbrains.annotations.NotNull;
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
public interface IProjectEndpoint {

    @WebMethod
    void editProject(@WebParam(name = "sessionDTO") @NotNull final SessionDTO sessionDTO,
                     @WebParam(name = "projectId") @NotNull final String id,
                     @WebParam(name = "name") @NotNull final String name,
                     @WebParam(name = "description") @NotNull final String description
    ) throws AccessForbiddenException;


    @WebMethod
    void createProject(@WebParam(name = "sessionDTO") @NotNull final SessionDTO sessionDTO,
                       @WebParam(name = "name") @NotNull final String name,
                       @WebParam(name = "description") @NotNull final String description
    ) throws AccessForbiddenException;

    @WebMethod
    void removeProject(@WebParam(name = "sessionDTO") @NotNull final SessionDTO sessionDTO,
                       @WebParam(name = "id") @NotNull final String id) throws AccessForbiddenException;

    @WebMethod
    ProjectDTO findOneProject(@WebParam(name = "sessionDTO") @NotNull final SessionDTO sessionDTO,
                              @WebParam(name = "id") @NotNull final String id) throws AccessForbiddenException;

    void removeAllProject(@WebParam(name = "sessionDTO") @NotNull final SessionDTO sessionDTO) throws AccessForbiddenException;

    @WebMethod
    Collection<ProjectDTO> showAllProject(@WebParam(name = "sessionDTO") @NotNull final SessionDTO sessionDTO) throws AccessForbiddenException;

}
