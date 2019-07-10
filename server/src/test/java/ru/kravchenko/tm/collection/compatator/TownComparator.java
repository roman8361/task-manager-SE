package ru.kravchenko.tm.collection.compatator;

import java.util.Comparator;

/**
 * @author Roman Kravchenko
 */

public class TownComparator implements Comparator<Town> {

    @Override
    public int compare(Town o1, Town o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
