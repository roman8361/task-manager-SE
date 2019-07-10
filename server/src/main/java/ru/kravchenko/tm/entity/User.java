package ru.kravchenko.tm.entity;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.AbstractEntity;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class User extends AbstractEntity {

    @Nullable
    private String login;

    @Nullable
    private String passwordHash;

    @Nullable
    private Status role = Status.USER;

    @Nullable
    boolean locked;

    @Override
    public String toString() {
        return "login: " + login + " password: " + passwordHash + " userStatus: " + role +
                " id: " + super.getId();
    }

}
