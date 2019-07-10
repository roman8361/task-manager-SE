package ru.kravchenko.tm.serialization.ser;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import org.jetbrains.annotations.Nullable;
import org.junit.Test;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.StatusProjectTask;
import ru.kravchenko.tm.entity.Task;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@XmlRootElement(name="project")
@XmlAccessorType(XmlAccessType.FIELD)
public class MappingTest {

    private Map projectRepository = new LinkedHashMap<>();

    @Test
    @SneakyThrows
    public void testSerializableToByteFile() {
//        final LoginDTO login = new LoginDTO();
//        login.setLogin("ad11122min");
//        login.setPassword("qwerty");
        addData2();

        final File file = new File ("D:\\ser\\map\\data.tmp");
        final FileOutputStream fileOutputStream = new FileOutputStream(file);

        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(projectRepository);
        objectOutputStream.close();
        objectOutputStream.close();
        System.out.println(file.getAbsoluteFile());
    }

    @Test
    @SneakyThrows
    public void testSerializableFromByteFile() {
        final FileInputStream fileInputStream = new FileInputStream(new File("D:\\ser\\tm\\data.tmp"));
        final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        final Map projectRepository = (Map) objectInputStream.readObject();
        fileInputStream.close();
        objectInputStream.close();
        System.out.println(projectRepository.values());
    }


    @Test
    @SneakyThrows
    public void testSerializableFromByte() {
        final LoginDTO login = new LoginDTO();
        login.setLogin("admin");
        login.setPassword("qwerty mother fucker");

        final byte[] data = returnByteArrays(login);

        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        final ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        final LoginDTO loginDTOLoader = (LoginDTO) objectInputStream.readObject();
        byteArrayInputStream.close();
        objectInputStream.close();
        System.out.println(loginDTOLoader.getLogin());
        System.out.println(loginDTOLoader.getPassword());
    }

    @SneakyThrows
    private byte[] returnByteArrays(final LoginDTO login) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(login);
        objectOutputStream.close();
        byteArrayOutputStream.close();

        final byte[] data = byteArrayOutputStream.toByteArray();
        return data;
    }


    @Test
    @SneakyThrows
    public void testToJSON() {
        final LoginDTO login = new LoginDTO();
        login.setLogin("admin");
        login.setPassword("qwerty");

        final ObjectMapper objectMapper = new ObjectMapper();
        final String jsonPrettyPrinter = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(login);
        final String json = objectMapper.writeValueAsString(login);
        objectMapper.writeValue(new File("D:\\ser\\omtojson.json"), login);

        System.out.println(json);
    }

    @Test
    @SneakyThrows
    public void testFromJSON() {
  //      final String json = "{ \"login\": \"123\", \"password\": \"456\" }";
        final ObjectMapper objectMapper = new ObjectMapper();

//        final LoginDTO login = objectMapper.readValue(json, LoginDTO.class);
        final LoginDTO login = objectMapper.readValue(new File("D:\\ser\\omtojson.json"), LoginDTO.class);
        System.out.println(login);
        System.out.println(login.getLogin());
        System.out.println(login.getPassword());
    }

    @Test
    @SneakyThrows
    public void testToXML() {
        final LoginDTO login = new LoginDTO();
        login.setLogin("adminXML");
        login.setPassword("qwerty");

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("D:\\ser\\omtojson.xml"), login);
        final String xmlPrettyPrinter = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(login);
        final String xml = xmlMapper.writeValueAsString(login);

        System.out.println(xml);
    }

    @Test
    @SneakyThrows
    public void testFromXML() {
     //   final String xml = "<LoginDTO><login>admin</login><password>qwerty</password></LoginDTO>";
        XmlMapper xmlMapper = new XmlMapper();
        final LoginDTO login = xmlMapper.readValue(new File("D:\\ser\\omtojson.xml"), LoginDTO.class);
        System.out.println(login);
        System.out.println(login.getLogin());
        System.out.println(login.getPassword());
    }

    @Test
    @SneakyThrows
    public void testToXMLJAXB() {
        final LoginDTO login = new LoginDTO();
        login.setLogin("admin123");
        login.setPassword("qwerty");

        final File file = new File("D:\\ser\\jaxbtoxml.xml");
        JAXBContext context = JAXBContext.newInstance(LoginDTO.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(login, file);
        marshaller.marshal(login, System.out);
    }

    @Test
    @SneakyThrows
    public void testFromXMLJAXB() {
        File file = new File("D:\\ser\\jaxbtoxml.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(LoginDTO.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        LoginDTO login = (LoginDTO) jaxbUnmarshaller.unmarshal(file);
        System.out.println(login);
        System.out.println(login.getPassword());
        System.out.println(login.getLogin());
    }

    @Test
    @SneakyThrows
    public void testFromJSONJAXB() {
        File file = new File("D:\\ser\\jaxbtojson.json");
        final JAXBContext jaxbContext = JAXBContext.newInstance(LoginDTO.class);
        final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        jaxbUnmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");
        final LoginDTO login = (LoginDTO) jaxbUnmarshaller.unmarshal(file);
        System.out.println(login);
        System.out.println(login.getPassword());
        System.out.println(login.getLogin());

    }

    @Test
    @SneakyThrows
    public void testToJsonJAXB() {
        final LoginDTO login = new LoginDTO();
        login.setLogin("admin");
        login.setPassword("qwerty");

        JAXBContext jaxbContext = JAXBContext.newInstance(LoginDTO.class);
        File file = new File("D:\\ser\\jaxbtojson.json");

        // Create the Marshaller Object using the JaxB Context
        Marshaller marshaller = jaxbContext.createMarshaller();

        // Set the Marshaller media type to JSON or XML
        marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");

        // Set it to true if you need to include the JSON root element in the JSON output
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Set it to true if you need the JSON output to formatted
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Marshal the employee object to JSON and print the output to console
        marshaller.marshal(login, System.out);
        marshaller.marshal(login, file);
    }

    public void addData() {
        Project project1 = new Project("first");
        project1.setDisplayName(StatusProjectTask.PROCESS);
        project1.setDescription("FIRST");
        project1.setDateBegin(new Date());
        project1.setDateEnd(new Date());

        Project project2 = new Project("second");
        project2.setDisplayName(StatusProjectTask.PROCESS);
        project2.setDescription("SECOND");
        project2.setDateBegin(new Date());
        project2.setDateEnd(new Date());

        Project project3 = new Project("third");
        project3.setDisplayName(StatusProjectTask.PROCESS);
        project3.setDescription("THIRD");
        project3.setDateBegin(new Date());
        project3.setDateEnd(new Date());

//        projectRepository.put(project1.getName(), project1);
//        projectRepository.put(project2.getName(), project2);
//        projectRepository.put(project3.getName(), project3);

        projectRepository.put(project1.getId(), project1);
        projectRepository.put(project2.getId(), project2);
        projectRepository.put(project3.getId(), project3);

      //  System.out.println(projectRepository);
    }

    public void addData2() {
        Project project1 = new Project("first project");
        project1.setDisplayName(StatusProjectTask.PROCESS);
        project1.setDescription("FIRST PROJECT");
        project1.setDateBegin(new Date());
        project1.setDateEnd(new Date());

        Task task1 = new Task();
        task1.setDisplayName(StatusProjectTask.PROCESS);
        task1.setDescription("FIRST TASK");
        task1.setProject(project1);
        task1.setName("Task1 name");



        Project project2 = new Project("second");
        project2.setDisplayName(StatusProjectTask.PROCESS);
        project2.setDescription("SECOND");
        project2.setDateBegin(new Date());
        project2.setDateEnd(new Date());

        Task task2 = new Task();
        task2.setDisplayName(StatusProjectTask.PROCESS);
        task2.setDescription("SECOND TASK");
        task2.setProject(project2);
        task2.setName("Task222 name");

//
//        Project project3 = new Project("third");
//        project3.setDisplayName(StatusProjectTask.PROCESS);
//        project3.setDescription("THIRD");
//        project3.setDateBegin(new Date());
//        project3.setDateEnd(new Date());
//
        projectRepository.put(task1.getId(), task1);
        projectRepository.put(task2.getId(), task2);
//        projectRepository.put(project3.getName(), project3);

        //  System.out.println(projectRepository);
    }

    @Test
    @SneakyThrows
    public void testOMMapToJSON() {
        addData2();
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("D:\\ser\\map\\maptojsontask.json"), projectRepository);
    }

    @Test
    @SneakyThrows
    public void testOMJSONToMap2() {
        final ObjectMapper objectMapper = new ObjectMapper();
        final Map result = objectMapper.readValue(new File("D:\\ser\\map\\maptojsontask.json"), Map.class);
        System.out.println(result.values());
    }

    @Test
    @SneakyThrows
    public void testOMJSONToMap() {
        final ObjectMapper objectMapper = new ObjectMapper();
        final Map result = objectMapper.readValue(new File("D:\\ser\\map\\maptojson.json"), Map.class);
        System.out.println(result.get("second"));
    }

    @Test
    @SneakyThrows
    public void testOMMapToXML() {
        addData();
        final XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new File("D:\\ser\\map\\maptoxml.xml"), projectRepository);
    }

    @Test
    @SneakyThrows
    public void testOMXMLToMap() {
//        System.out.println(projectRepository.get("first"));
        final ObjectMapper  xmlMapper = new XmlMapper();
        final File file = new File("D:\\ser\\map\\maptoxml.xml");
        Map  map = xmlMapper.readValue(file, Map.class);
    //    projectRepository = xmlMapper.readValue(file, Map.class);
        System.out.println(map);
//        final ObjectMapper  xmlMapper = new XmlMapper();
//        final File file = new File("D:\\ser\\tm\\maptoxml.xml");
//        Map map = xmlMapper.readValue(file, Map.class);
//        System.out.println(map);
    }

//    @Test
//    @SneakyThrows
//    public void testToXMLJAXB() {
//        final LoginDTO login = new LoginDTO();
//        login.setLogin("admin123");
//        login.setPassword("qwerty");
//
//        final File file = new File("D:\\ser\\jaxbtoxml.xml");
//        JAXBContext context = JAXBContext.newInstance(LoginDTO.class);
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.marshal(login, file);
//        marshaller.marshal(login, System.out);
//    }

    @Test
    @SneakyThrows
    public void testJAXBMapToXML() {
        addData();
        JAXBContext jaxbContext = JAXBContext.newInstance(MappingTest.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(projectRepository, System.out);
        jaxbMarshaller.marshal(projectRepository, new File("d:/ser/map/projects.xml"));

//        final File file = new File("D:\\ser\\map\\jaxbtoxml.xml");
//        JAXBContext context = JAXBContext.newInstance(Map.class);
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.marshal(projectRepository, file);
    }

    @Test
    @SneakyThrows
    public void testJAXBXMLToMap() {


    }


}
