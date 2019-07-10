package ru.kravchenko.tm.collection.compatator;

import ru.kravchenko.tm.entity.Project;

import java.util.Comparator;

/**
 * @author Roman Kravchenko
 */
public class ComparatorProjectDateBegin implements Comparator<Project> {

    @Override
    public int compare(Project o1, Project o2) {
        return o1.getDateBegin().compareTo(o2.getDateBegin());
    }

}
