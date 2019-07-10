package ru.kravchenko.tm.service;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;
import ru.kravchenko.tm.api.service.ITerminalService;

import java.util.Scanner;

/**
 * @author Roman Kravchenko
 */

@Getter
@Service
public class TerminalService implements ITerminalService {

    @NotNull
    private final Scanner scanner = new Scanner(System.in);

    @Nullable
    public String nextLine() {
        return scanner.nextLine();
    }

}
