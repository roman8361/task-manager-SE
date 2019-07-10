package ru.kravchenko.tm.test.soap.testcollection;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.api.service.IServiceLocator;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.User;
import ru.kravchenko.tm.exception.AccessForbiddenException;
import ru.kravchenko.tm.exception.UserNotFoundException;
import ru.kravchenko.tm.repository.UserRepositoryBean;
import ru.kravchenko.tm.service.LocatorServiceBean;
import ru.kravchenko.tm.service.ProjectServiceBean;
import ru.kravchenko.tm.service.UserServiceBean;

import java.util.Date;

/**
 * @author Roman Kravchenko
 */

public class Test {

    public static void main(String[] args) throws UserNotFoundException, AccessForbiddenException {

        Project project1 = new Project();
        project1.setName("ddd");
        project1.setDescription("aaa");
        project1.setDateBegin(new Date());
        project1.setDateEnd(new Date());

        Project project2 = new Project();
        project2.setName("qqq");
        project2.setDescription("aaaaaa");
        project2.setDateBegin(new Date());
        project2.setDateEnd(new Date());

        User user = new User();
//
//        user.getProjects().add(project1);
//        user.getProjects().add(project2);

        System.out.println(user);





    }

}
