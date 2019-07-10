package ru.kravchenko.tm.testnotnull;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.Test;

/**
 * @author Roman Kravchenko
 */

public class TestNPE {

    @Test
    public void test() {
        test(null);
    }

    private void test(@Nullable String value) {
        if (value == null || value.isEmpty()) return;
        value.hashCode();
        System.out.println(value);
    }

}
