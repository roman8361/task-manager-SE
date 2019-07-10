
package ru.kravchenko.tm.endpoint;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-06-10T12:22:22.763+03:00
 * Generated source version: 3.2.7
 */

@WebFault(name = "SessionNotFoundException", targetNamespace = "http://endpoint.tm.kravchenko.ru/")
public class SessionNotFoundException_Exception extends Exception {

    private ru.kravchenko.tm.endpoint.SessionNotFoundException sessionNotFoundException;

    public SessionNotFoundException_Exception() {
        super();
    }

    public SessionNotFoundException_Exception(String message) {
        super(message);
    }

    public SessionNotFoundException_Exception(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public SessionNotFoundException_Exception(String message, ru.kravchenko.tm.endpoint.SessionNotFoundException sessionNotFoundException) {
        super(message);
        this.sessionNotFoundException = sessionNotFoundException;
    }

    public SessionNotFoundException_Exception(String message, ru.kravchenko.tm.endpoint.SessionNotFoundException sessionNotFoundException, java.lang.Throwable cause) {
        super(message, cause);
        this.sessionNotFoundException = sessionNotFoundException;
    }

    public ru.kravchenko.tm.endpoint.SessionNotFoundException getFaultInfo() {
        return this.sessionNotFoundException;
    }
}
