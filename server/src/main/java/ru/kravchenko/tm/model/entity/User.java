package ru.kravchenko.tm.model.entity;

import com.sun.istack.internal.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.model.dto.UserDTO;

import javax.persistence.*;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "app_User")
public class User extends AbstractEntity {

    @Nullable
    @Column(name = "login")
    private String login;

    @Nullable
    @Column(name = "passwordHash")
    private String passwordHash;

    @Nullable
    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Status role = Status.USER;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Session> session;

    @Nullable
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects;

    @Nullable
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

    @Override
    public String toString() {
        return "login: " + login + " password: " + passwordHash + " userStatus: " + role +
                " id: " + getId();
    }

    public UserDTO getDTO() {
        @NotNull final UserDTO dto = new UserDTO();
        dto.setId(id);
        dto.setLogin(login);
        dto.setPassword(null);
        dto.setRole(role);
        return dto;
    }

}
