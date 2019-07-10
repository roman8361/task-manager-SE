package ru.kravchenko.tm.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-05-30T00:38:19.406+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint.tm.kravchenko.ru/", name = "UserEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface UserEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.tm.kravchenko.ru/UserEndpoint/registryUserRequest", output = "http://endpoint.tm.kravchenko.ru/UserEndpoint/registryUserResponse", fault = {@FaultAction(className = UserLoginBusyException_Exception.class, value = "http://endpoint.tm.kravchenko.ru/UserEndpoint/registryUser/Fault/UserLoginBusyException")})
    @RequestWrapper(localName = "registryUser", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.RegistryUser")
    @ResponseWrapper(localName = "registryUserResponse", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.RegistryUserResponse")
    public void registryUser(
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    ) throws UserLoginBusyException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.kravchenko.ru/UserEndpoint/authorizationRequest", output = "http://endpoint.tm.kravchenko.ru/UserEndpoint/authorizationResponse", fault = {@FaultAction(className = UserNotFoundException_Exception.class, value = "http://endpoint.tm.kravchenko.ru/UserEndpoint/authorization/Fault/UserNotFoundException")})
    @RequestWrapper(localName = "authorization", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.Authorization")
    @ResponseWrapper(localName = "authorizationResponse", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.AuthorizationResponse")
    public void authorization(
        @WebParam(name = "login", targetNamespace = "")
        java.lang.String login,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    ) throws UserNotFoundException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.tm.kravchenko.ru/UserEndpoint/logoutRequest", output = "http://endpoint.tm.kravchenko.ru/UserEndpoint/logoutResponse")
    @RequestWrapper(localName = "logout", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.Logout")
    @ResponseWrapper(localName = "logoutResponse", targetNamespace = "http://endpoint.tm.kravchenko.ru/", className = "ru.kravchenko.tm.endpoint.LogoutResponse")
    public void logout(
        @WebParam(name = "sessionDTO", targetNamespace = "")
        ru.kravchenko.tm.endpoint.SessionDTO sessionDTO
    );
}
