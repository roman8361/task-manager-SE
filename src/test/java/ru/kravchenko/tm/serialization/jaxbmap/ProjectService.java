package ru.kravchenko.tm.serialization.jaxbmap;

import lombok.Getter;
import lombok.Setter;
import ru.kravchenko.tm.entity.Project;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectService {

//    private Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
    private Map<String, Project> projectMap = new HashMap<String, Project>();

//    public Map<Integer, Employee> getEmployeeMap() {
//        return employeeMap;
//    }
//
//    public void setEmployeeMap(Map<Integer, Employee> employeeMap) {
//        this.employeeMap = employeeMap;
//    }

}
