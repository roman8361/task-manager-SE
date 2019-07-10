package ru.kravchenko.tm.test.mapdispacher;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

public class MapMain {

    private static Map<String,GetNameClass> map = new HashMap<>();

    public static void main(String[] args) {
        GetNameClass mega = new MegaService();
        GetNameClass best = new BestService();

        map.put("1", mega);
        map.put("2", best);

        String input = "2";

        chekInput(input);

    }


    private static void chekInput(@Nullable String userInput)  {
        if (userInput == null || userInput.isEmpty()) return;
        if (map.containsKey(userInput)) map.get(userInput).getNameClass();
    }

}
