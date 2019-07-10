package ru.kravchenko.tm;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.tm.api.repository.ProjectRepository;
import ru.kravchenko.tm.api.repository.UserRepository;
import ru.kravchenko.tm.bootstrap.AppConfig;
import ru.kravchenko.tm.model.entity.Project;
import ru.kravchenko.tm.model.entity.User;

import java.util.Date;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ProjectTest {
    private Lorem lorem = new LoremIpsum();

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

//    @Test
    public void addAnyProject() {
        for (int i = 0; i < 5; i++) addOneProject();
    }

    private void addOneProject() {
        projectRepository.save(dateProject());
    }

    private Project dateProject() {
        final Project project = new Project();
        project.setName(lorem.getWords(1));
        project.setDescription(lorem.getWords(3));

        return project;
    }

  //  @Test
    public void clear() {
        projectRepository.deleteAll();
    }

 //   @Test
    public void findById() {
        System.out.println(projectRepository.findById("08c18e65-cbcf-4f26-9b39-e21eb2b5a329").get().getDescription());
    }

  //  @Test
    public void finaAllId() {
        final List<String> logins = projectRepository.findAllId();
        for (String s: logins) System.out.println(s);
    }

 //   @Test
    public void findByUser() {
        final User user  = userRepository.findById("a0f9ba5f-8221-4a44-9f2c-58d9e7f31dd5").get();
        final List<Project> projectList = projectRepository.findByUser(user);
        for (Project p: projectList) System.out.println(p.getName());
    }

    @Test
    public void projectTestCRUD() {
        final List<Project> projectList = projectRepository.findAll();
        final Project project = new Project();
        project.setName(lorem.getFirstName());
        project.setDateBegin(new Date());
        project.setDateEnd(new Date());
        project.setDescription(lorem.getWords(4));
        projectRepository.save(project);

        final Project projectInsert = projectRepository.findById(project.getId()).get();
        Assert.assertNotNull(projectInsert);
        projectRepository.deleteById(projectInsert.getId());
        Assert.assertNotNull(projectRepository.findById(project.getId()));
    }

}
