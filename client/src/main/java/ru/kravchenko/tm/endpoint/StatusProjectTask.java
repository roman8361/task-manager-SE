
package ru.kravchenko.tm.endpoint;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for statusProjectTask.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="statusProjectTask"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="PLANNED"/&gt;
 *     &lt;enumeration value="PROCESS"/&gt;
 *     &lt;enumeration value="COMPLETED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "statusProjectTask")
@XmlEnum
public enum StatusProjectTask {

    PLANNED,
    PROCESS,
    COMPLETED;

    public String value() {
        return name();
    }

    public static StatusProjectTask fromValue(String v) {
        return valueOf(v);
    }

}
