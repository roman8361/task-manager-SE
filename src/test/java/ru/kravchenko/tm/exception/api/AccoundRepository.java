package ru.kravchenko.tm.exception.api;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.exception.exception.AccountNotFoundException;
import ru.kravchenko.tm.exception.model.Accound;

/**
 * @author Roman Kravchenko
 */

public interface AccoundRepository {

    Accound find(final @NotNull String id) throws AccountNotFoundException;

    Accound get(final @NotNull String id);

}
