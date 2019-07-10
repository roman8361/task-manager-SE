package ru.kravchenko.tm.level12.test;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import lombok.SneakyThrows;
import org.junit.Test;
import ru.kravchenko.tm.test.level12.fromlesson.ProjectDAO;
import ru.kravchenko.tm.test.level12.fromlesson.entity.ProjectDTO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Roman Kravchenko
 */

public class ProjectTest {

    @Test
    public void test() throws Exception {
//        final ProjectDAO projectDAO = new ProjectDAO();
//        projectDAO.getManager().connect();
//        final List<ProjectDTO> projects = projectDAO.findAllProject();
//        System.out.println(projects.get(0).getDateBegin());
//        System.out.println(projects.get(0).getDescription());
//        System.out.println(projects.get(0).getName());
//        String name  = projects.get(0).getName();
//        System.out.println(name);
//        projectDAO.getManager().disconnect();
    }

    @Test
    public void testCRUD() throws Exception {
//        Lorem lorem = LoremIpsum.getInstance();
//        final ProjectDAO projectDAO = new ProjectDAO();
//        projectDAO.getManager().connect();
//
//        final List<ProjectDTO> projects = projectDAO.findAllProject();
//
//        final ProjectDTO project = new ProjectDTO();
//        project.setId(UUID.randomUUID().toString());
//        project.setName(lorem.getWords(1));
//        project.setDescription(lorem.getWords(5));
//        project.setDateBegin(new Date());
//        project.setDateEnd(new Date());
//        projectDAO.insert(project);

//        final ProjectDTO projectInsert = projectDAO.findById(project.getId());
//        Assert.assertNotNull(projectInsert);

//        projectInsert.setDescription("Demonstration...");
//        projectDAO.update(project);

//        projectDAO.removeById(project.getId());
//        Assert.assertNull(projectDAO.findById(project.getId()));
 //       projectDAO.getManager().disconnect();
    }

    @Test
    public void delCRUD() throws Exception {
//        final ProjectDAO projectDAO = new ProjectDAO();
//        projectDAO.getManager().connect();
//
//        projectDAO.removeById("8176db08-82cb-43df-b066-f1ccfd5a3557");
//        projectDAO.getManager().disconnect();
    }

    @Test
    public void findOn() throws Exception {
//        final ProjectDAO projectDAO = new ProjectDAO();
//        projectDAO.getManager().connect();
//        final ProjectDTO projectInsert = projectDAO.findById("c4ea5f6f-6e73-4953-8093-7fe767952688");
//        System.out.println(projectInsert.getName());
    }

    @Test
    @SneakyThrows
    public void testAdd() {
        for (int i = 0; i < 10; i++) {
            testCRUD();
        }
    }

    @Test
    public void loremTest() {
        Lorem lorem = LoremIpsum.getInstance();
        System.out.println(lorem.getPhone());
        System.out.println(lorem.getWords(10));
    }

}
