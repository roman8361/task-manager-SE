package ru.kravchenko.tm.serialization.jaxbmap;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.StatusProjectTask;
import ru.kravchenko.tm.repository.ProjectRepositoryBean;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Roman Kravchenko
 */
public class App {

    private static HashMap<String, Project> map = new HashMap<String, Project>();

    public static void main(String[] args) throws JAXBException {
        testJAXBXMLToMap();

    }

    private static void testJAXBJsonToMap() {}

    private static void testJAXBMapToJson() throws JAXBException {
        addData();
        ProjectService projectService = new ProjectService();
        projectService.setProjectMap(map);

        JAXBContext jaxbContext = JAXBContext.newInstance(ProjectService.class);
        File file = new File("D:\\ser\\map\\jaxbtojsonmap.json");

        Marshaller marshaller = jaxbContext.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Set the Marshaller media type to JSON or XML
        marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");

//        // Set it to true if you need to include the JSON root element in the JSON output
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Set it to true if you need the JSON output to formatted
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(projectService, System.out);
        marshaller.marshal(projectService, file);
    }




    private static void testJAXBXMLToMap() throws JAXBException {
//        JAXBContext jaxbContext = JAXBContext.newInstance(ProjectService.class);
//        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//        ProjectService empMap = (ProjectService) jaxbUnmarshaller.unmarshal( new File("d:/ser/jaxbmaptoeml.xml"));
//        System.out.println(empMap.getProjectMap().values());

        JAXBContext jaxbContext = JAXBContext.newInstance(ProjectRepositoryBean.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ProjectRepositoryBean bean = (ProjectRepositoryBean) jaxbUnmarshaller.unmarshal(new File("d:/ser/tm/jaxbmaptoxml.xml"));
//        bean.showAllProject();
    }

    private static void testJAXBMapToXML() throws JAXBException {
        //Add employees in map
        addData();

        ProjectService employeeMap = new ProjectService();
        employeeMap.setProjectMap(map);

        /******************** Marshalling example *****************************/

        JAXBContext jaxbContext = JAXBContext.newInstance(ProjectService.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(employeeMap, System.out);
        jaxbMarshaller.marshal(employeeMap, new File("d:/ser/jaxbmaptoeml.xml"));
    }



    private static void testJAXBJasonToMap() {

    }


        private static void addData() {
        Project project1 = new Project("first");
     //   project1.setDisplayName(StatusProjectTask.PROCESS);
        project1.setDescription("FIRST");
        project1.setDateBegin(new Date());
        project1.setDateEnd(new Date());

        Project project2 = new Project("second");
   ///     project2.setDisplayName(StatusProjectTask.PROCESS);
        project2.setDescription("SECOND");
        project2.setDateBegin(new Date());
        project2.setDateEnd(new Date());

        Project project3 = new Project("third");
      //  project3.setDisplayName(StatusProjectTask.PROCESS);
        project3.setDescription("THIRD");
        project3.setDateBegin(new Date());
        project3.setDateEnd(new Date());

            map.put(project1.getName(), project1);
            map.put(project2.getName(), project2);
            map.put(project3.getName(), project3);

        //  System.out.println(projectRepository);
    }

}
