package ru.kravchenko.tm.endpoint;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.endpoint.IProjectEndpoint;
import ru.kravchenko.tm.api.service.IServiceLocator;
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
@NoArgsConstructor
public class ProjectEndpoint implements IProjectEndpoint {

    @NotNull
    private IServiceLocator serviceLocator;

    public ProjectEndpoint(@NotNull final IServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    @Override
    @WebMethod
    public void createProject(@WebParam(name = "session") @NotNull final Session session,
                              @WebParam(name = "name") @NotNull final String name,
                              @WebParam(name = "description") @NotNull final String description) throws AccessForbiddenException, UserNotFoundException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getProjectService().createProject(session, name, description);
        System.out.println("PROJECT CREATE");
        serviceLocator.getProjectRepository();
    }


    @Override
    public void removeProject(@WebParam(name = "session") @NotNull final Session session,
                              @WebParam(name = "name") @NotNull final String projectId) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getProjectRepository().removeById(projectId);
    }

    @Override
    public Project findOneProject(@NotNull final Session session,
                                  @NotNull final String projectId) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        return serviceLocator.getProjectRepository().findOne(projectId);
    }

    @Override
    @WebMethod
    public void removeAllProject(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getProjectRepository().removeAllProject(session.getUserId());
    }

    @Override
    @WebMethod
    public Collection<Project> showAllProject(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        final Collection<Project> result = serviceLocator.getProjectRepository().findAllUserId(session.getUserId());
        return result;
    }

    @Override
    @WebMethod
    public Collection<Project> sortByStatus(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        final Collection<Project> result = serviceLocator.getProjectRepository().sortByStatus(session.getUserId());
        return result;
    }

    @Override
    @WebMethod
    public Collection<Project> sortByDateBegin(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        final Collection<Project> result = serviceLocator.getProjectRepository().sortByDateBegin(session.getUserId());
        return result;
    }

    @Override
    @WebMethod
    public Collection<Project> sortByDateEnd(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        final Collection<Project> result = serviceLocator.getProjectRepository().sortByDateEnd(session.getUserId());
        return result;
    }

    @Override
    @WebMethod
    public void saveDateSerializ(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getProjectService().saveDateSerializ();
    }

    @Override
    public void loadDateSerializ(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getProjectService().loadDateSerializ();
    }

    @Override
    public void saveDateJAXBtoXML(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getProjectService().saveDateJAXBtoXML();
    }

    @Override
    public void loadDateJAXBtoMapFromXML(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getProjectService().loadDateJAXBtoMapFromXML();
    }

    @Override
    public void saveDateJAXBtoJson(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getProjectService().saveDateJAXBtoJson();
    }

    @Override
    public void loadDateJAXBtoMapFromJson(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getProjectService().loadDateJAXBtoMapFromJson();
    }

    @Override
    public void saveDateOMtoJson(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getProjectService().saveDateOMtoJson();
    }

    @Override
    public void loadDateOMtoJson(@WebParam(name = "session") @NotNull final Session session) throws AccessForbiddenException {
        serviceLocator.getSessionService().validate(session);
        serviceLocator.getProjectService().loadDateOMtoJson();
    }

}
