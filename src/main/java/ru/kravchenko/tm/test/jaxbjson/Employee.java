package ru.kravchenko.tm.test.jaxbjson;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@XmlRootElement
public class Employee {

    private int id;

    private String name;

    private List skills;

}
