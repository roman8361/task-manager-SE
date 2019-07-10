package ru.kravchenko.tm.collection.testhash;

import java.util.Objects;

/**
 * @author Roman Kravchenko
 */

public class Town {

    private String name;

    public Town(String name) { this.name = name; }

    @Override
    public String toString() { return name; }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Town town = (Town) o;
//        return Objects.equals(name, town.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }

}
