package ru.kravchenko.tm.serialization.jaxbjson;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@XmlRootElement
public class Employee {

    private int id;

    private String name;

    private List skills;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getSkills() {
        return skills;
    }

    public void setSkills(List skills) {
        this.skills = skills;
    }

}
