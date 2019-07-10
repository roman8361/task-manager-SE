package ru.kravchenko.tm.test.soap.testfieldlogin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.entity.User;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */


public class TestFieldLogin {

    static Map<String, User> userRepository = new LinkedHashMap<>();


    public static void main(String[] args) {
        dateAdd();
     //   System.out.println(chekLogin("fedor861"));
        System.out.println(chekPasswordLogin("roman", "www"));
    }

    static boolean chekLogin(@Nullable final String login) {
        for (User u: userRepository.values()) {
            if (login.equals(u.getLogin())) return false;
        }
        return true;
    }

    static boolean chekPasswordLogin(final @Nullable String login, final @Nullable String password) {
        if (login == null || login.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        for (User u: userRepository.values()) {
//            if (login.equals(u.getLogin()) && password.equals(u.getPassword())) return true;
        }
        return false;
    }

    static void dateAdd() {

//        User user1 = new User();
//        user1.setLogin("roman");
//        user1.setPassword("wwww");
//
//        User user2 = new User();
//        user2.setLogin("ivan");
//        user2.setPassword("qqq");
//
//        User user3 = new User();
//        user3.setLogin("roman2");
//        user3.setPassword("rrr");
//
//        User user4 = new User();
//        user4.setLogin("fedor86");
////        user4.setPassword("jjjj");
//
//        userRepository.put(user1.getId(), user1);
//        userRepository.put(user2.getId(), user2);
//        userRepository.put(user3.getId(), user3);
//        userRepository.put(user4.getId(), user4);
    }

}
