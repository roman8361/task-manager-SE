package ru.kravchenko.tm.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Roman Kravchenko
 */
@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
public enum Status implements Serializable {

    ADMIN,

    USER

}
