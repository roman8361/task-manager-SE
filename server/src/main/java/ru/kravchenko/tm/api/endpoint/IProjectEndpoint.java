package ru.kravchenko.tm.api.endpoint;


import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.exception.AccessForbiddenException;

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
    void editProject  (@WebParam(name = "session") @NotNull final Session session,
                       @WebParam(name = "projectId") @NotNull final String id,
                       @WebParam(name = "name") @NotNull final String name,
                       @WebParam(name = "description") @NotNull final String description
    ) throws AccessForbiddenException;


    @WebMethod
    void createProject(@WebParam(name = "session") @NotNull final Session session,
                       @WebParam(name = "name") @NotNull final String name,
                       @WebParam(name = "description") @NotNull final String description
    )throws AccessForbiddenException;

    @WebMethod
    void removeProject(@WebParam(name = "session") @NotNull final Session session,
                       @WebParam(name = "id") @NotNull final String id) throws AccessForbiddenException;

    @WebMethod
    Project findOneProject(@WebParam(name = "session") @NotNull final Session session,
                           @WebParam(name = "id") @NotNull final String id) throws AccessForbiddenException;

    void removeAllProject(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException;

    @WebMethod
    Collection<Project> showAllProject(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException;

}
