package ru.kravchenko.tm.sort;

import ru.kravchenko.tm.entity.Project;

import java.util.Comparator;

/**
 * @author Roman Kravchenko
 */

public class ComparatorProjectDateEnd implements Comparator<Project> {

    @Override
    public int compare(Project o1, Project o2) {
        return o1.getDateEnd().compareTo(o2.getDateEnd());
    }

}
