package ru.kravchenko.tm.serialization.jaxbjson;

import org.eclipse.persistence.jaxb.MarshallerProperties;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

public class MarshallerDemo {

    /**
     * @param args
     * @throws JAXBException
     * Marshaller POJO to JSON using EclipseLink MOXy
     */
    public static void main(String[] args) throws JAXBException {

        // Creating a new employee pojo object with data
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Ashraf");
        List skills = new ArrayList();
        skills.add("java");
        skills.add("sql");
        employee.setSkills(skills);

        // Create a JaxBContext
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
     //   System.setProperty("javax.xml.bind.context.factory","org.eclipse.persistence.jaxb.JAXBContextFactory");

        File file = new File("D:\\file.json");

        // Create the Marshaller Object using the JaxB Context
        Marshaller marshaller = jaxbContext.createMarshaller();

        // Set the Marshaller media type to JSON or XML
        marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");

        // Set it to true if you need to include the JSON root element in the JSON output
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Set it to true if you need the JSON output to formatted
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Marshal the employee object to JSON and print the output to console
        marshaller.marshal(employee, System.out);

        marshaller.marshal(employee, file);
    }

}
