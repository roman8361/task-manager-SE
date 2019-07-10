package ru.kravchenko.tm.service;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.service.ITerminalService;

import java.util.Scanner;

/**
 * @author Roman Kravchenko
 */

@Getter
public class TerminalService implements ITerminalService {

    @NotNull
    private final Scanner scanner = new Scanner(System.in);

    @Nullable
    public String nextLine() {
        return scanner.nextLine();
    }

}
