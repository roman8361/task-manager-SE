package ru.kravchenko.tm.api;

import lombok.Getter;
import lombok.Setter;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.exception.UserNotCorrectInputException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Roman Kravchenko
 */


public abstract class AbstractCommand {

    @Setter
    public IServiceLocator serviceLocator;

    public abstract String getName();

    public abstract void getDescription();

    public abstract void execute();

}
