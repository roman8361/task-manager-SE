
package ru.kravchenko.tm.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.kravchenko.tm.endpoint package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UserLoginBusyException_QNAME = new QName("http://endpoint.tm.kravchenko.ru/", "UserLoginBusyException");
    private final static QName _UserNotFoundException_QNAME = new QName("http://endpoint.tm.kravchenko.ru/", "UserNotFoundException");
    private final static QName _Authorization_QNAME = new QName("http://endpoint.tm.kravchenko.ru/", "authorization");
    private final static QName _AuthorizationResponse_QNAME = new QName("http://endpoint.tm.kravchenko.ru/", "authorizationResponse");
    private final static QName _Logout_QNAME = new QName("http://endpoint.tm.kravchenko.ru/", "logout");
    private final static QName _LogoutResponse_QNAME = new QName("http://endpoint.tm.kravchenko.ru/", "logoutResponse");
    private final static QName _RegistryUser_QNAME = new QName("http://endpoint.tm.kravchenko.ru/", "registryUser");
    private final static QName _RegistryUserResponse_QNAME = new QName("http://endpoint.tm.kravchenko.ru/", "registryUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.kravchenko.tm.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UserLoginBusyException }
     * 
     */
    public UserLoginBusyException createUserLoginBusyException() {
        return new UserLoginBusyException();
    }

    /**
     * Create an instance of {@link UserNotFoundException }
     * 
     */
    public UserNotFoundException createUserNotFoundException() {
        return new UserNotFoundException();
    }

    /**
     * Create an instance of {@link Authorization }
     * 
     */
    public Authorization createAuthorization() {
        return new Authorization();
    }

    /**
     * Create an instance of {@link AuthorizationResponse }
     * 
     */
    public AuthorizationResponse createAuthorizationResponse() {
        return new AuthorizationResponse();
    }

    /**
     * Create an instance of {@link Logout }
     * 
     */
    public Logout createLogout() {
        return new Logout();
    }

    /**
     * Create an instance of {@link LogoutResponse }
     * 
     */
    public LogoutResponse createLogoutResponse() {
        return new LogoutResponse();
    }

    /**
     * Create an instance of {@link RegistryUser }
     * 
     */
    public RegistryUser createRegistryUser() {
        return new RegistryUser();
    }

    /**
     * Create an instance of {@link RegistryUserResponse }
     * 
     */
    public RegistryUserResponse createRegistryUserResponse() {
        return new RegistryUserResponse();
    }

    /**
     * Create an instance of {@link SessionDTO }
     * 
     */
    public SessionDTO createSessionDTO() {
        return new SessionDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserLoginBusyException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.kravchenko.ru/", name = "UserLoginBusyException")
    public JAXBElement<UserLoginBusyException> createUserLoginBusyException(UserLoginBusyException value) {
        return new JAXBElement<UserLoginBusyException>(_UserLoginBusyException_QNAME, UserLoginBusyException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.kravchenko.ru/", name = "UserNotFoundException")
    public JAXBElement<UserNotFoundException> createUserNotFoundException(UserNotFoundException value) {
        return new JAXBElement<UserNotFoundException>(_UserNotFoundException_QNAME, UserNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Authorization }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.kravchenko.ru/", name = "authorization")
    public JAXBElement<Authorization> createAuthorization(Authorization value) {
        return new JAXBElement<Authorization>(_Authorization_QNAME, Authorization.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthorizationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.kravchenko.ru/", name = "authorizationResponse")
    public JAXBElement<AuthorizationResponse> createAuthorizationResponse(AuthorizationResponse value) {
        return new JAXBElement<AuthorizationResponse>(_AuthorizationResponse_QNAME, AuthorizationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Logout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.kravchenko.ru/", name = "logout")
    public JAXBElement<Logout> createLogout(Logout value) {
        return new JAXBElement<Logout>(_Logout_QNAME, Logout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.kravchenko.ru/", name = "logoutResponse")
    public JAXBElement<LogoutResponse> createLogoutResponse(LogoutResponse value) {
        return new JAXBElement<LogoutResponse>(_LogoutResponse_QNAME, LogoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistryUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.kravchenko.ru/", name = "registryUser")
    public JAXBElement<RegistryUser> createRegistryUser(RegistryUser value) {
        return new JAXBElement<RegistryUser>(_RegistryUser_QNAME, RegistryUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistryUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.kravchenko.ru/", name = "registryUserResponse")
    public JAXBElement<RegistryUserResponse> createRegistryUserResponse(RegistryUserResponse value) {
        return new JAXBElement<RegistryUserResponse>(_RegistryUserResponse_QNAME, RegistryUserResponse.class, null, value);
    }

}
