package ru.kravchenko.tm.test.mapdispacher;

import ru.kravchenko.tm.service.TerminalService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

public class MapMain {

    private static Map<String, AbstractClass> map = new HashMap<>();

    AbstractClass abstractClass;

    private static TerminalService terminalService = new TerminalService();

    public static void main(String[] args) {
        String user = terminalService.nextLine();
        System.out.println("User enter: " + user);

    }




}


//      System.out.println("Please enter best or mega "); из Маина
//              Scanner scanner = new Scanner(System.in);
//              String userInput = scanner.nextLine();
//              registry(userInput);
//              System.out.println(map);
//              if (map.containsKey(userInput)) map.get(userInput).execute();
//
//
//
//              System.out.println("Please enter best or mega ");
//              scanner = new Scanner(System.in);
//              userInput = scanner.nextLine();
//              registry(userInput);
//              if (map.containsKey(userInput)) map.get(userInput).execute();
//
//              System.out.println(map);