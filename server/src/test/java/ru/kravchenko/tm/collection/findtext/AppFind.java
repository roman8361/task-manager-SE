package ru.kravchenko.tm.collection.findtext;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.StatusProjectTask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

public class AppFind {

    static List<Project> collection = new ArrayList<>();

    static {
        @NotNull final Project project1 = new Project("project1");
        project1.setDateBegin(addDateBeginProject("01.05.2019"));
        project1.setDateEnd((addDateBeginProject("31.05.2019")));
        project1.setDescription("project1");
   //     project1.setDisplayName(StatusProjectTask.PROCESS);

        @NotNull final Project project2 = new Project("project2");
        project2.setDateBegin(addDateBeginProject("01.01.2019"));
        project2.setDateEnd((addDateBeginProject("01.01.2020")));
        project2.setDescription("project2");

        @NotNull final Project project3 = new Project("project3");
        project3.setDateBegin(addDateBeginProject("11.04.2014"));
        project3.setDateEnd((addDateBeginProject("10.10.2014")));
        project3.setDescription("project3");
    //    project3.setDisplayName(StatusProjectTask.PROCESS);

        @NotNull final Project project4 = new Project("project4");
        project4.setDateBegin(addDateBeginProject("25.07.2015"));
        project4.setDateEnd((addDateBeginProject("13.10.2016")));
        project4.setDescription("project4");
    //    project4.setDisplayName(StatusProjectTask.COMPLETED);

        @NotNull final Project project5 = new Project("project5");
        project5.setDateBegin(addDateBeginProject("17.02.2017"));
        project5.setDateEnd((addDateBeginProject("03.05.2018")));
        project5.setDescription("project5");

        collection.add(project1);
        collection.add(project2);
        collection.add(project3);
        collection.add(project4);
        collection.add(project5);
    }

    @SneakyThrows
    static Date addDateBeginProject(@NotNull final String date) {
        @NotNull final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        @NotNull final Date newDate = simpleDateFormat.parse(date);
        return newDate;
    }

    public static void main(String[] args) {

    }

    @Test
    public void test01() {
        String stringFind = "pro";
        for (Project p : collection) {
            if (p.getDescription().contains(stringFind)) {
                System.out.println("pro is exist");
                System.out.println(p);
            } else {
                System.out.println("not exist");
            }
        }
    }


    @Test
    public void test02() {
        String stringFind = "project";
        for (Project project : collection) {
            if (project.getName().contains(stringFind)) System.out.println(project);
        }
    }


}
