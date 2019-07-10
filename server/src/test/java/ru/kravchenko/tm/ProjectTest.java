package ru.kravchenko.tm;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.kravchenko.tm.api.repository.ProjectRepository;
import ru.kravchenko.tm.api.repository.UserRepository;
import ru.kravchenko.tm.model.entity.Project;
import ru.kravchenko.tm.model.entity.User;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@RunWith(CdiTestRunner.class)
public class ProjectTest {

    @Inject
    private ProjectRepository projectRepository;

    @Inject
    private UserRepository userRepository;

    private Lorem lorem = new LoremIpsum();

    @Test
    public void addAnyProject() {
        for (int i = 0; i < 10; i++) addOneProject();
    }

    private void addOneProject() {
        projectRepository.persist(date());
    }

    private Project date() {
        final Project project = new Project();
        project.setDateBegin(new Date());
        project.setDateEnd(new Date());
        project.setName(lorem.getWords(1));
        project.setDescription(lorem.getWords(4));
        return project;
    }

    @Test
    public void clearProject() {
        projectRepository.removeAll();
    }

    @Test
    public void findAllProjectByUserId() {
        final User user = userRepository.findBy("ac32fd9c-c319-43e0-8aca-30b11327a07e");
        List<Project> userProject = projectRepository.findByUser(user);
        for (Project p: userProject) System.out.println(p);
    }

    @Test
    public void findAllIds() {
        System.out.println(projectRepository.findAllId());
    }

    @Test
    public void findAll() {
        System.out.println(projectRepository.findAll());
    }

    @Test
    public void findProjectById() {
        System.out.println(projectRepository.findBy("06fa3a2a-262e-4581-8129-67f19357f78f").getName());
    }

    @Test
    public void removeById() {
        projectRepository.removeById("ac112e5b-5236-48c0-b1ce-7dd075461dfc");
    }

    @Test
    public void removeAllProjectByUserId() {
       final String userId = "ac32fd9c-c319-43e0-8aca-30b11327a07e";
       final User user = userRepository.findBy(userId);
       final List<Project> userProjectsList = projectRepository.findByUser(user);
       for (Project p: userProjectsList) projectRepository.removeById(p.getId());
    }

    @Test
    public void projectTestCRUD() {
        final List<Project> projectList = projectRepository.findAll();
        final Project project = new Project();
        project.setName(lorem.getFirstName());
        project.setDateBegin(new Date());
        project.setDateEnd(new Date());
        project.setDescription(lorem.getWords(4));
        projectRepository.persist(project);

        final Project projectInsert = projectRepository.findBy(project.getId());
        Assert.assertNotNull(projectInsert);
        projectRepository.removeById(projectInsert.getId());
        Assert.assertNull(projectRepository.findBy(project.getId()));
    }

}
