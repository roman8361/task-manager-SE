package ru.kravchenko.tm.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-06-06T10:09:51.588+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint.tm.kravchenko.ru/", name = "TaskEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface TaskEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.tm.kravchenko.ru/TaskEndpoint/createTaskRequest", output = "http://endpoint.tm.kravchenko.ru/TaskEndpoint/createTaskResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.tm.kravchenko.ru/TaskEndpoint/createTask/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "createTask", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.CreateTask")
    @ResponseWrapper(localName = "createTaskResponse", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.CreateTaskResponse")
    public void createTask(
        @WebParam(name = "sessionDTO", targetNamespace = "")
        ru.kravchenko.tm.endpoint.SessionDTO sessionDTO,
        @WebParam(name = "projectId", targetNamespace = "")
        java.lang.String projectId,
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name,
        @WebParam(name = "description", targetNamespace = "")
        java.lang.String description
    ) throws AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.kravchenko.ru/TaskEndpoint/findOneTaskRequest", output = "http://endpoint.tm.kravchenko.ru/TaskEndpoint/findOneTaskResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.tm.kravchenko.ru/TaskEndpoint/findOneTask/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "findOneTask", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.FindOneTask")
    @ResponseWrapper(localName = "findOneTaskResponse", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.FindOneTaskResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.kravchenko.tm.endpoint.TaskDTO findOneTask(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.kravchenko.tm.endpoint.SessionDTO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.kravchenko.ru/TaskEndpoint/getAllTaskByUserIdRequest", output = "http://endpoint.tm.kravchenko.ru/TaskEndpoint/getAllTaskByUserIdResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.tm.kravchenko.ru/TaskEndpoint/getAllTaskByUserId/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "getAllTaskByUserId", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.GetAllTaskByUserId")
    @ResponseWrapper(localName = "getAllTaskByUserIdResponse", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.GetAllTaskByUserIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.kravchenko.tm.endpoint.TaskDTO> getAllTaskByUserId(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.kravchenko.tm.endpoint.SessionDTO arg0
    ) throws AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.kravchenko.ru/TaskEndpoint/removeAllTaskByUserIdRequest", output = "http://endpoint.tm.kravchenko.ru/TaskEndpoint/removeAllTaskByUserIdResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.tm.kravchenko.ru/TaskEndpoint/removeAllTaskByUserId/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "removeAllTaskByUserId", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.RemoveAllTaskByUserId")
    @ResponseWrapper(localName = "removeAllTaskByUserIdResponse", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.RemoveAllTaskByUserIdResponse")
    public void removeAllTaskByUserId(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.kravchenko.tm.endpoint.SessionDTO arg0
    ) throws AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.kravchenko.ru/TaskEndpoint/removeTaskRequest", output = "http://endpoint.tm.kravchenko.ru/TaskEndpoint/removeTaskResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.tm.kravchenko.ru/TaskEndpoint/removeTask/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "removeTask", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.RemoveTask")
    @ResponseWrapper(localName = "removeTaskResponse", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.RemoveTaskResponse")
    public void removeTask(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.kravchenko.tm.endpoint.SessionDTO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws AccessForbiddenException_Exception;
}
