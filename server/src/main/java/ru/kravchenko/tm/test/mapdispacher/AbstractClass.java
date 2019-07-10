package ru.kravchenko.tm.test.mapdispacher;

/**
 * @author Roman Kravchenko
 */

abstract class AbstractClass {

    public abstract String getName();

    public abstract void execute();

    @Override
    public String toString() {
        return this.getName() ;
    }

}
