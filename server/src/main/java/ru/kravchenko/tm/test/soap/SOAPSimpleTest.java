package ru.kravchenko.tm.test.soap;

import lombok.Getter;
import lombok.Setter;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.WebServiceRef;

/**
 * @author Roman Kravchenko
 */


@Getter
@Setter
@WebService
public class SOAPSimpleTest {

    @WebServiceRef
    private String test = "test";

    @WebMethod
    public String messssage() {
        return "Hello from SERVER";
    }

    public static void main(String[] args) {
        System.out.println("Server run");
        Endpoint.publish("http://localhost:8080/SOAPSimpleTest?wsdl", new SOAPSimpleTest());
    }

}
