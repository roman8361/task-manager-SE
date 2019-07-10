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
 * 2019-05-30T00:38:19.159+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint.tm.kravchenko.ru/", name = "SessionEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface SessionEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.tm.kravchenko.ru/SessionEndpoint/validateAdminSessionRequest", output = "http://endpoint.tm.kravchenko.ru/SessionEndpoint/validateAdminSessionResponse")
    @RequestWrapper(localName = "validateAdminSession", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.ValidateAdminSession")
    @ResponseWrapper(localName = "validateAdminSessionResponse", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.ValidateAdminSessionResponse")
    public void validateAdminSession(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.kravchenko.tm.endpoint.Session arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.kravchenko.ru/SessionEndpoint/openSessionRequest", output = "http://endpoint.tm.kravchenko.ru/SessionEndpoint/openSessionResponse", fault = {@FaultAction(className = SessionNotFoundException_Exception.class, value = "http://endpoint.tm.kravchenko.ru/SessionEndpoint/openSession/Fault/SessionNotFoundException"), @FaultAction(className = UserNotFoundException_Exception.class, value = "http://endpoint.tm.kravchenko.ru/SessionEndpoint/openSession/Fault/UserNotFoundException")})
    @RequestWrapper(localName = "openSession", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.OpenSession")
    @ResponseWrapper(localName = "openSessionResponse", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.OpenSessionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.kravchenko.tm.endpoint.SessionDTO openSession(
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login
    ) throws SessionNotFoundException_Exception, UserNotFoundException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.kravchenko.ru/SessionEndpoint/validateSessionRequest", output = "http://endpoint.tm.kravchenko.ru/SessionEndpoint/validateSessionResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.tm.kravchenko.ru/SessionEndpoint/validateSession/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "validateSession", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.ValidateSession")
    @ResponseWrapper(localName = "validateSessionResponse", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.ValidateSessionResponse")
    public void validateSession(
        @WebParam(name = "sessionDTO", targetNamespace = "")
        ru.kravchenko.tm.endpoint.SessionDTO sessionDTO
    ) throws AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.kravchenko.ru/SessionEndpoint/closeSessionRequest", output = "http://endpoint.tm.kravchenko.ru/SessionEndpoint/closeSessionResponse")
    @RequestWrapper(localName = "closeSession", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.CloseSession")
    @ResponseWrapper(localName = "closeSessionResponse", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.CloseSessionResponse")
    public void closeSession(
        @WebParam(name = "session", targetNamespace = "")
        ru.kravchenko.tm.endpoint.Session session
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.kravchenko.ru/SessionEndpoint/testRequest", output = "http://endpoint.tm.kravchenko.ru/SessionEndpoint/testResponse")
    @RequestWrapper(localName = "test", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.Test")
    @ResponseWrapper(localName = "testResponse", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.TestResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String test(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.kravchenko.ru/SessionEndpoint/getUserRequest", output = "http://endpoint.tm.kravchenko.ru/SessionEndpoint/getUserResponse")
    @RequestWrapper(localName = "getUser", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.GetUser")
    @ResponseWrapper(localName = "getUserResponse", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.GetUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.kravchenko.tm.endpoint.User getUser(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.kravchenko.tm.endpoint.Session arg0
    );

    @WebMethod
    @Action(input = "http://endpoint.tm.kravchenko.ru/SessionEndpoint/getListSessionRequest", output = "http://endpoint.tm.kravchenko.ru/SessionEndpoint/getListSessionResponse")
    @RequestWrapper(localName = "getListSession", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.GetListSession")
    @ResponseWrapper(localName = "getListSessionResponse", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.GetListSessionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.kravchenko.tm.endpoint.Session> getListSession(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.kravchenko.tm.endpoint.Session arg0
    );
}
