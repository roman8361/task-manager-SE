package ru.kravchenko.tm.collection.testhash;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * @author Roman Kravchenko
 */

public class HashCode {

    public static void main(String[] args) {

    }

    @Test
    public void testHashCode() {
        final Integer number1 = 1;
        System.out.println("HashCode: " + hashCode(number1));
        System.out.println("MD5: " + md5(number1.toString()));
        System.out.println("SHA256: " + sha256(number1.toString()));

        System.out.println(md5("LiFe"));

    }

    private String md5(String original) { return DigestUtils.md5Hex(original); }

    private String sha256(String original) { return DigestUtils.sha256Hex(original); }

    private int hashCode (Integer original) { return original.hashCode(); }

}
