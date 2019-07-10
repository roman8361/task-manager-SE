package ru.kravchenko.tm.api.endpoint;

import org.springframework.stereotype.Controller;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author Roman Kravchenko
 */

@Controller
@WebService
public interface IServerEndpoint {

    @WebMethod
    String getInfoHost();

    @WebMethod
    String getInfoPort();

}