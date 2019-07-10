package ru.kravchenko.tm.collection.compatator;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.Test;
import ru.kravchenko.tm.entity.Project;
import ru.kravchenko.tm.entity.StatusProjectTask;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Roman Kravchenko
 */

public class AppTown {

    @Test
    public void test() {
        final List<Town> towns = new ArrayList<>();
        towns.add(new Town("Мурманск", 303754));
        towns.add(new Town("Нягань", 55638));
        towns.add(new Town("Екатиренбург", 1387000));
        towns.add(new Town("Санкт-Петербург", 4991000));
        towns.add(new Town("Москва", 11920000));
        System.out.println("ORIGINAL");
        System.out.println(towns);
        System.out.println();

        System.out.println("BY COUNTS");
        Collections.sort(towns);
        System.out.println(towns);
        System.out.println();

        System.out.println("BY NAME");
        Collections.sort(towns, new TownComparator());
        System.out.println(towns);
    }

    @Test
    public void test02() {
        @Nullable final Map<String, Project> projectRepository = new LinkedHashMap<>();

        @NotNull final Project project1 = new Project("1");
        project1.setDateBegin(addDateBeginProject("01.05.2019"));
        project1.setDateEnd((addDateBeginProject("31.05.2019")));
        project1.setDescription("project1");
  //      project1.setDisplayName(StatusProjectTask.PROCESS);

        @NotNull final Project project2 = new Project("2");
        project2.setDateBegin(addDateBeginProject("01.01.2019"));
        project2.setDateEnd((addDateBeginProject("01.01.2020")));
        project2.setDescription("project2");

        @NotNull final Project project3 = new Project("3");
        project3.setDateBegin(addDateBeginProject("11.04.2014"));
        project3.setDateEnd((addDateBeginProject("10.10.2014")));
        project3.setDescription("project3");
  //      project3.setDisplayName(StatusProjectTask.PROCESS);

        @NotNull final Project project4 = new Project("4");
        project4.setDateBegin(addDateBeginProject("25.07.2015"));
        project4.setDateEnd((addDateBeginProject("13.10.2016")));
        project4.setDescription("project4");
     ///   project4.setDisplayName(StatusProjectTask.COMPLETED);

        @NotNull final Project project5 = new Project("5");
        project5.setDateBegin(addDateBeginProject("17.02.2017"));
        project5.setDateEnd((addDateBeginProject("03.05.2018")));
        project5.setDescription("project5");

        projectRepository.put(project1.getId(), project1);
        projectRepository.put(project2.getId(), project2);
        projectRepository.put(project3.getId(), project3);
        projectRepository.put(project4.getId(), project4);
        projectRepository.put(project5.getId(), project5);

        System.out.println("SORT BY ADD TO REPOSITORY");
        List<Project> listAdd = new LinkedList<>();

        for (Map.Entry<String, Project> map : projectRepository.entrySet()) {
            listAdd.add(map.getValue());
        }

        for (Project c : listAdd) {
            System.out.println(c);
        }

    //    List<Project> listDateBegin = new ArrayList<>();
        System.out.println();
        System.out.println("SORT BY DATE BEGIN");
        List<Project> listDateBegin = new ArrayList<>();

        for (Map.Entry<String, Project> map : projectRepository.entrySet()) {
            listDateBegin.add(map.getValue());
        }

        Collections.sort(listDateBegin, new ComparatorProjectDateBegin());
        for (Project c : listDateBegin) {
            System.out.println(c);
        }

        List<Project> listDateEnd = new ArrayList<>();
        System.out.println();
        System.out.println("SORT BY DATE END");

        for (Map.Entry<String, Project> map : projectRepository.entrySet()) {
            listDateEnd.add(map.getValue());
        }

        Collections.sort(listDateEnd, new ComparatorProjectDateEnd());
        for (Project c : listDateEnd) {
            System.out.println(c);
        }

        List<Project> listDisplayName = new ArrayList<>();
        System.out.println();
        System.out.println("SORT BY STATUS");

        for (Map.Entry<String, Project> map : projectRepository.entrySet()) {
            listDisplayName.add(map.getValue());
        }

//        Collections.sort(listDisplayName, new ComparatorProjectStatus());
//        for (Project c : listDisplayName) {
//            System.out.println(c);
//        }
    }


    @SneakyThrows
    public Date addDateBeginProject(@NotNull final String date) {
        @NotNull final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        @NotNull final Date newDate = simpleDateFormat.parse(date);
        return newDate;
    }


    @NotNull
    public Project getProject(@Nullable final String name) {
        @NotNull final Project project = new Project(name);
        project.setDateBegin(new Date());
        project.setDateEnd(new Date());
        return project;
    }


    @Test
    public void test03() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("one", 1);
        map.put("ten", 10);
        map.put("two", 2);
        map.put("nine", 9);
        map.put("three", 3);
        map.put("eight", 8);

        //     List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(map.entrySet());
    }

    @Test
    public void test04() {
       @NotNull final String s = "www.mysite.com";
   //     boolean isContain1 = s.contains("mysite");
      //  System.out.println("www".contains(s));// нашел - выведет true
        System.out.println(s.contains("wm"));// нашел - выведет true
    }


    public Collection<Project> findAll(@NotNull final Map projectRepository) {
        return projectRepository.values();
    }

}

