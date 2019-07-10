package ru.kravchenko.tm.test.mapdispacher;

/**
 * @author Roman Kravchenko
 */
public class MegaService implements GetNameClass {

    public void getNameClass() {
        System.out.println("NAME CLASS IS:  " + getClass().getCanonicalName());
    }

}
