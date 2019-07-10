package ru.kravchenko.tm.api.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Roman Kravchenko
 */

@WebService
public interface IServerEndpoint {

    @WebMethod
    String getInfoHost();

    @WebMethod
    String getInfoPort();

}