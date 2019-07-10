
package ru.kravchenko.tm.endpoint;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-06-06T10:09:51.688+03:00
 * Generated source version: 3.2.7
 */

@WebFault(name = "UserLoginBusyException", targetNamespace = "http://endpoint.tm.kravchenko.ru/")
public class UserLoginBusyException_Exception extends Exception {

    private ru.kravchenko.tm.endpoint.UserLoginBusyException userLoginBusyException;

    public UserLoginBusyException_Exception() {
        super();
    }

    public UserLoginBusyException_Exception(String message) {
        super(message);
    }

    public UserLoginBusyException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public UserLoginBusyException_Exception(String message, ru.kravchenko.tm.endpoint.UserLoginBusyException userLoginBusyException) {
        super(message);
        this.userLoginBusyException = userLoginBusyException;
    }

    public UserLoginBusyException_Exception(String message, ru.kravchenko.tm.endpoint.UserLoginBusyException userLoginBusyException, java.lang.Throwable cause) {
        super(message, cause);
        this.userLoginBusyException = userLoginBusyException;
    }

    public ru.kravchenko.tm.endpoint.UserLoginBusyException getFaultInfo() {
        return this.userLoginBusyException;
    }
}
