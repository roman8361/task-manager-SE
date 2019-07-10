package ru.kravchenko.tm.entity;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.AbstractEntity;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class Task extends AbstractEntity {

    @Nullable
    private Project project;

    @Nullable
    private String name;

    @Nullable
    private String description;

    @NotNull
    private StatusProjectTask displayName = StatusProjectTask.PLANNED;

    @Override
    public String toString() {
        return "TASK NAME: \"" + this.name + "\" DESCRIPTION TASK: \"" + this.description + "\" " + "TASK ID: " +
                super.getId() + " PROJECT: " + this.project + " STATUS: " + this.displayName;
    }

}
