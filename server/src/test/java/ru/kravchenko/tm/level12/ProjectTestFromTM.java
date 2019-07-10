package ru.kravchenko.tm.level12;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.Test;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.test.level12.fromtm.ProjectServ;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Roman Kravchenko
 */

public class ProjectTestFromTM {

    private Lorem lorem = LoremIpsum.getInstance();
    private final ProjectServ projectServ = new ProjectServ();

    @Test
    public void addProject() throws Exception {
        projectServ.getManager().connect();
        final Project project = new Project();
        project.setId(UUID.randomUUID().toString());
        project.setName(lorem.getWords(1));
        project.setDescription(lorem.getWords(5));
        project.setDateBegin(new Date());
        project.setDateEnd(new Date());
        projectServ.insert(project);
        projectServ.getManager().disconnect();
    }

    @Test
    public void delProject() throws Exception {
        projectServ.getManager().connect();
        projectServ.removeById("26f55862-0bd9-469c-b9d7-f7766cadb8b3");
        projectServ.getManager().disconnect();
    }

    @Test
    public void findById() throws Exception {
        projectServ.getManager().connect();
        Project project = projectServ.findOne("5ab01e7c-d872-4df9-906d-0deef0121b41");
        System.out.println(project.getName());
    }

    @Test
    public void findAll() throws Exception {
        projectServ.getManager().connect();
        final List<Project> projects = projectServ.findAll();
        System.out.println(projects.get(0).getName());
        System.out.println(projects.get(1).getName());
    }

    @Test
    public void findByName() throws Exception {
        projectServ.getManager().connect();
        Project project = projectServ.findByName("suas");
        System.out.println(project.getDescription());
    }

    @Test
    public void clear() throws Exception {
        projectServ.getManager().connect();
        projectServ.clear();
    }



}
