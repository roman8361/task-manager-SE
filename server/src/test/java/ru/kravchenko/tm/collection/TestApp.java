package ru.kravchenko.tm.collection;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import ru.kravchenko.tm.collection.testhash.Town;

import java.util.*;

/**
 * @author Roman Kravchenko
 */
public class TestApp {

    @Test
    public void test() {
        final Collection<Town> towns = new LinkedHashSet<>();
        towns.add(new Town("Самара"));
        towns.add(new Town("Саратов"));
        towns.add(new Town("Мурманск"));
        towns.add(new Town("Магадан"));
        towns.add(new Town("Москва"));
        towns.add(new Town("Санкт-Петербург"));
        towns.add(new Town("Санкт-Петербург"));
        towns.add(new Town("Санкт-Петербург"));
        System.out.println(towns);
    }

    @Test
    public void test2() {
        final Map <String, String> towns = new LinkedHashMap<>();
        towns.put(UUID.randomUUID().toString(), "Киров");
        towns.put(UUID.randomUUID().toString(), "Житомир");
        towns.put(UUID.randomUUID().toString(), "Ивангород");
        towns.put(UUID.randomUUID().toString(), "Мурманск");
        towns.put(UUID.randomUUID().toString(), "Нижневартовск");
        towns.put(UUID.randomUUID().toString(), "Хабаровск");

        System.out.println(towns);
    }

    @Test
    public void test3() {
        System.out.println(DigestUtils.md5Hex("2222"));
    }

}
