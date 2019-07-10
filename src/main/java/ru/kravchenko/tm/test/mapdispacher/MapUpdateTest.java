package ru.kravchenko.tm.test.mapdispacher;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */
public class MapUpdateTest {

    public static void main(String[] args) {
        Map<Integer, String> name = new HashMap<>();
        name.put(1, "Ivan");
        name.put(2, "Vovan");
        name.put(3, "Fedor");
        name.put(4, "Gesha");
        System.out.println(name);
        name.put(2, "Roman");
        System.out.println(name);
    }

}
