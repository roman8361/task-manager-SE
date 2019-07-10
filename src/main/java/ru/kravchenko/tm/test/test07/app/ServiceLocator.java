package ru.kravchenko.tm.test.test07.app;

import lombok.Getter;

/**
 * @author Roman Kravchenko
 */

@Getter
public class ServiceLocator {

    private IServiceA iServiceA = new ServiceA();

    private IServiceB iServiceB = new ServiceB();


    public ServiceLocator getServiceLocator() {
        return this;
    }

    //private IServiceLocator serviceLocator = new IServiceLocator();

}
