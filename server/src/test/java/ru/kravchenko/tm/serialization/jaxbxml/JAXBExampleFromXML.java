package ru.kravchenko.tm.serialization.jaxbxml;

import lombok.SneakyThrows;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author Roman Kravchenko
 */

public class JAXBExampleFromXML {

    @SneakyThrows
    public static void main(String[] args) {
            File file = new File("D:\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
            System.out.println(customer);
            System.out.println(customer.getAge());
            System.out.println(customer.getId());
            System.out.println(customer.getName());
    }

}
