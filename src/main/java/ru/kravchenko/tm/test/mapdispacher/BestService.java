package ru.kravchenko.tm.test.mapdispacher;

/**
 * @author Roman Kravchenko
 */

public class BestService implements GetNameClass {

    @Override
    public void getNameClass() {
        System.out.println("NAME CLASS IS:  " + getClass().getCanonicalName());
    }
}
