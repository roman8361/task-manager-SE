package ru.kravchenko.tm.test;

import lombok.SneakyThrows;
import ru.kravchenko.tm.repository.ProjectServiceBean;
import ru.kravchenko.tm.repository.TaskServiceBean;
import ru.kravchenko.tm.test.singleton.Singleton;
import ru.kravchenko.tm.test.singleton.TestServiceSingletonProject;
import ru.kravchenko.tm.test.singleton.TestServiceSingletonTask;

import java.text.ParseException;
import java.util.UUID;

/**
 * @author Roman Kravchenko
 */

public class TestApp {

    public static void main(String[] args) throws ParseException {

        ProjectServiceBean singletonProject = ProjectServiceBean.getInstance();
        TaskServiceBean singletonTask = TaskServiceBean.getInstance();

        singletonProject.createProject();
        singletonTask.createTask();



    }

    public static void testSingleton() {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        singleton.getIdUser().add(UUID.randomUUID().toString());
        singleton.getIdUser().add(UUID.randomUUID().toString());
        singleton.getIdUser().add(UUID.randomUUID().toString());
        singleton.getIdUser().add(UUID.randomUUID().toString());
        System.out.println(singleton.hashCode());
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }

    @SneakyThrows
    public static void testWorkkingSingleton() {
        TestServiceSingletonProject singletonProject = TestServiceSingletonProject.getInstance();
        TestServiceSingletonTask singletonTask = TestServiceSingletonTask.getInstance();

        singletonProject.createProject();
        singletonProject.showAllProject();

        singletonTask.createTask();
        singletonTask.showAllTask();
    }

}
