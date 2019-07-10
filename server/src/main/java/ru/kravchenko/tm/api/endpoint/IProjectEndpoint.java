package ru.kravchenko.tm.api.endpoint;


import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.exception.AccessForbiddenException;
import ru.kravchenko.tm.exception.UserNotFoundException;

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
    void createProject(@WebParam(name = "session") @NotNull final Session session,
                       @WebParam(name = "name") @NotNull final String name,
                       @WebParam(name = "description") @NotNull final String description
    ) throws AccessForbiddenException, UserNotFoundException;

    @WebMethod
    void removeProject(@WebParam(name = "session") @NotNull final Session session,
                       @WebParam(name = "id") @NotNull final String id) throws AccessForbiddenException;

    @WebMethod
    Project findOneProject(@WebParam(name = "session") @NotNull final Session session,
                           @WebParam(name = "id") @NotNull final String id) throws AccessForbiddenException;

    @WebMethod
    Collection<Project> showAllProject(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException;

    @WebMethod
    void removeAllProject(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException;

    @WebMethod
    Collection<Project> sortByStatus(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException;

    @WebMethod
    Collection<Project> sortByDateBegin(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException;

    @WebMethod
    Collection<Project> sortByDateEnd(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException;

    @WebMethod
    void saveDateSerializ(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException;

    @WebMethod
    void loadDateSerializ(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException;

    @WebMethod
    void saveDateJAXBtoXML(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException;

    @WebMethod
    void loadDateJAXBtoMapFromXML(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException;

    @WebMethod
    void saveDateJAXBtoJson(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException;

    @WebMethod
    void loadDateJAXBtoMapFromJson(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException;

    @WebMethod
    void saveDateOMtoJson(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException;

    @WebMethod
    void loadDateOMtoJson(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException;

}
