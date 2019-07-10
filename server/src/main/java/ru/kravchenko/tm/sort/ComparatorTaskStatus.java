package ru.kravchenko.tm.sort;

import ru.kravchenko.tm.entity.Task;

import java.util.Comparator;

/**
 * @author Roman Kravchenko
 */

public class ComparatorTaskStatus implements Comparator<Task> {

    @Override
    public int compare(final Task o1, final Task o2) {
        return o1.getDisplayName().compareTo(o2.getDisplayName());
    }

}
