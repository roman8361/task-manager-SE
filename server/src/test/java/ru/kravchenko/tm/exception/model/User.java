package ru.kravchenko.tm.exception.model;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class User {

    @Nullable
    private String id;

    @Nullable
    private String login;

    @Nullable
    private String email;

}
