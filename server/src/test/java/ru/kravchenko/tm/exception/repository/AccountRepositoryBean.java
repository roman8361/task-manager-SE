package ru.kravchenko.tm.exception.repository;

import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.exception.api.AccoundRepository;
import ru.kravchenko.tm.exception.exception.AccountNotFoundException;
import ru.kravchenko.tm.exception.model.Accound;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Roman Kravchenko
 */

public class AccountRepositoryBean implements AccoundRepository {

    private final Map<String, Accound> account = new LinkedHashMap<>();

    @Override
    public Accound find(@NotNull final String id) {
        if (!account.containsKey(id)) {
            try {
                throw new AccountNotFoundException();
            } catch (AccountNotFoundException e) {
                e.printStackTrace();
            }
        }
        return account.get(id);
    }

    @Override
    public Accound get(@NotNull final String id) {
        if (id == null || id.isEmpty()) return null;
        return account.get(id);
    }

}
