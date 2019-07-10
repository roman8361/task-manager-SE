package ru.kravchenko.tm.serialization.OM;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.SneakyThrows;
import org.junit.Test;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.StatusProjectTask;
import ru.kravchenko.tm.entity.Task;

import java.io.File;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

public class OM {

    Map projectRepository = new LinkedHashMap();

    @Test
    @SneakyThrows
    public void testProjectToJson() {
        final Project project1 = new Project("first project");
        project1.setDisplayName(StatusProjectTask.PROCESS);
        project1.setDescription("FIRST PROJECT");
        project1.setDateBegin(new Date());
        project1.setDateEnd(new Date());

        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("D:\\ser\\json\\omtojson.json"), project1);
    }

    @Test
    @SneakyThrows
    public void testJsonToProject() {
        final ObjectMapper objectMapper = new ObjectMapper();
        final Project project = objectMapper.readValue(new File("D:\\ser\\json\\omtojson.json"), Project.class);
        System.out.println(project.getId());
    }

    @Test
    @SneakyThrows
    public void testProjectToXML() {
        final Project project1 = new Project("first project");
        project1.setDisplayName(StatusProjectTask.PROCESS);
        project1.setDescription("FIRST PROJECT");
        project1.setDateBegin(new Date());
        project1.setDateEnd(new Date());

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new File("D:\\ser\\json\\omtojson.xml"), project1);
    }

    @Test
    @SneakyThrows
    public void testXMLToProject() {
        XmlMapper xmlMapper = new XmlMapper();
        final Project project = xmlMapper.readValue(new File("D:\\ser\\json\\omtojson.xml"), Project.class);
        System.out.println(project.getId());
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
    public void testOMJSONToMap() {
        final ObjectMapper objectMapper = new ObjectMapper();
        final Map result = objectMapper.readValue(new File("D:\\ser\\map\\maptojsontask.json"), Map.class);
        System.out.println(result.values());
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
        final ObjectMapper  xmlMapper = new XmlMapper();
        final File file = new File("D:\\ser\\map\\maptoxml.xml");
        Map  map = xmlMapper.readValue(file, Map.class);
        System.out.println(map);
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

        Project project3 = new Project("third");
        project3.setDisplayName(StatusProjectTask.PROCESS);
        project3.setDescription("THIRD");
        project3.setDateBegin(new Date());
        project3.setDateEnd(new Date());

        projectRepository.put(task1.getId(), task1);
        projectRepository.put(task2.getId(), task2);
        projectRepository.put(project3.getName(), project3);

//          System.out.println(projectRepository);
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

        projectRepository.put(project1.getName(), project1);
        projectRepository.put(project2.getName(), project2);
        projectRepository.put(project3.getName(), project3);

//        projectRepository.put(project1.getId(), project1);
//        projectRepository.put(project2.getId(), project2);
//        projectRepository.put(project3.getId(), project3);

  //        System.out.println(projectRepository);
    }

}
