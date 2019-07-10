package ru.kravchenko.tm.level13;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.Test;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.Session;
import ru.kravchenko.tm.exception.AccessForbiddenException;
import ru.kravchenko.tm.service.LocatorServiceBean;

import java.util.Date;

/**
 * Unit test for simple App.
 */

public class ProjectTest {

    IServiceLocator serviceLocator = new LocatorServiceBean();

    private final Lorem lorem = new LoremIpsum();

//       private final ProjectService projectDAO = new ProjectService();

    public ProjectTest() throws Exception {
    }

    @Test
    public void testClearDate() {
        serviceLocator.getProjectService().clear();
        serviceLocator.getProjectService().commit();
    }

    @Test
    public void addDate() {
        for (int i = 0; i < 10; i++) {
            addOneProject();
        }
    }

    public void addOneProject() {
        final Lorem lorem = LoremIpsum.getInstance();
        final Project project = new Project();
        project.setName(lorem.getName());
        project.setDescription(lorem.getWords(4));
        project.setDateBegin(new Date());
        project.setDateEnd(new Date());
        serviceLocator.getProjectService().insert(project);
        serviceLocator.getProjectService().commit();
    }

    @Test
    public void removeById() {
//        projectDAO.removeById("abebdee0-27c6-457b-aaa9-85ee2559f31b");
//        projectDAO.commit();
    }

    @Test
    public void findAllProjectByUserId() {
//        final List<Project> list = projectDAO.findAllProjectByUserId("1");
//        for (Project p : list) {
//            System.out.println("ID: " + p.getId() + " NAME: " + p.getName() + " DESC: " + p.getDescription());
//        }
    }

    @Test
    public void findById() {
   //     final Project project = projectDAO.findOne("59d52f2d-02d3-462f-bee8-d84814cd8420");
    //    System.out.println(project.getStatus());

    }

    @Test
    public void removeAllByUserId() {
//        projectDAO.removeAllProjectByUserId("1");
//        projectDAO.commit();
    }

    @Test
    public void updateDate() {
//        final Project project = projectDAO.findOne("03b37a77-1a0d-48db-8a9e-ce8c45913969");
//        project.setName("ROMANOO");
//        projectDAO.removeById(project.getId());
//        projectDAO.commit();
//        projectDAO.insert(project);
//        projectDAO.commit();
    }

    @Test
    public void findAllId() {
   //     for (String s : projectDAO.ids()) System.out.println(s);
    }

    @Test
    public void addMany() throws AccessForbiddenException {
        for (int i = 0; i < 10; i++)  addProjectOneToRepository();

    }

    public void addProjectOneToRepository() throws AccessForbiddenException {
        Session session = serviceLocator.getSessionService().findOnByUserId("85df598f-d681-4cb1-8fd1-060c6d005013");
        serviceLocator.getProjectService().createProject(session,"q", "qqqq");
    }

    @Test
    public void removeProject() {
        Session session = serviceLocator.getSessionService().findOnByUserId("85df598f-d681-4cb1-8fd1-060c6d005013");
        System.out.println(serviceLocator.getProjectService().findById("3f8b59e0-cc80-41b6-ae1e-e32a0409689c").getDescription());
    }

    @Test
    public void createProject() throws AccessForbiddenException {
        Session session = serviceLocator.getSessionService().findOnByUserId("f8358340-67f5-4a7d-a119-d3b0b2c34faf");
        serviceLocator.getProjectService().createProject(session, "ddd", "fff");


    }

}
