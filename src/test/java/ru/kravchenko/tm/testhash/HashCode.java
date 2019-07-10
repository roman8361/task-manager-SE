package ru.kravchenko.tm.testhash;

import com.google.common.hash.Hashing;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * @author Roman Kravchenko
 */

public class HashCode {

    public static void main(String[] args) {
    }

    @Test
    public void testMd5() {
        System.out.println(md5("444"));
    }

    @Test
    public void teshSha256() {
        System.out.println(sha256("2333"));
    }


    private String md5(String original) {
        String md5Value = DigestUtils.md5Hex(original);
        return md5Value;
    }


    private String sha256(String original) {
        String sha256hex = DigestUtils.sha256Hex(original);
        return sha256hex;
    }

}
