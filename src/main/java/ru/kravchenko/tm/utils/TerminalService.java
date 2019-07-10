package ru.kravchenko.tm.utils;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Scanner;

/**
 * @author Roman Kravchenko
 */

@Getter
public class TerminalService {

    @NotNull
    private final Scanner scanner = new Scanner(System.in);

    @Nullable
    public String nextLine() { return scanner.nextLine(); }

}
