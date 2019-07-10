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
    private String password;

    @Nullable
    private Status userStatus;

    @Nullable
    private Project project;

    @Override
    public String toString() { return "login: " + login + " password: " + password + " userStatus: " + userStatus +
            " id: " + super.getId() + " \n project: " + project; }

}
