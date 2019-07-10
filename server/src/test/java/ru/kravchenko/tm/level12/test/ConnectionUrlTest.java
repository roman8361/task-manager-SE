package ru.kravchenko.tm.level12.test;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.service.LocatorServiceBean;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

public class ConnectionUrlTest {

    @NotNull
    private IServiceLocator serviceLocator = new LocatorServiceBean();

    public ConnectionUrlTest() throws Exception {
    }

    @Test
    public void test() throws Exception {
        Project project = new Project();
        project.setName("lala");

        Project project1 = serviceLocator.getProjectRepository().findById("61fbf166-84a2-45c7-a9b9-aa76390f8fe8");
        System.out.println(project1.getName());

//        Project project1 = serviceLocator.getProjectRepository().findById("57768609-7a08-4f76-bad7-b7e7ffe13c8c");
//        System.out.println(project1.getId());


    }

}
