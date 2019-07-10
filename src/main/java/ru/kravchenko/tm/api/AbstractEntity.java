package ru.kravchenko.tm.api;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;
import java.util.UUID;

/**
 * @author Roman Kravchenko
 */

@Getter
public abstract class AbstractEntity {

    @Nullable
    private final String id = UUID.randomUUID().toString();

}
