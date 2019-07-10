package ru.kravchenko.tm.serialization.jaxbxml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Roman Kravchenko
 */


@Getter
@Setter
@XmlRootElement
class Customer {

    private String name;

    private int age;

    private int id;

//    public String getName() {
//        return name;
//    }
//
//   // @XmlElement
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    @XmlElement
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//  //  @XmlAttribute
//    public void setId(int id) {
//        this.id = id;
//    }

}
