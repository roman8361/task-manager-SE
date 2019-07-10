package ru.kravchenko.tm.entity;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;
import java.util.UUID;

/**
 * @author Roman Kravchenko
 */

@Getter
public abstract class AbstractEntity {

    @Nullable
    private String id = UUID.randomUUID().toString();

}
