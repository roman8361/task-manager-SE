package ru.kravchenko.tm.exception.model;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class Accound {

    @Nullable
    private String id;

    @Nullable
    private String name;

}
