package ru.kravchenko.tm.test.singleton;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class Singleton {

    List<String> idUser = new ArrayList<>();

    private static Singleton instance;

    private Singleton () {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
