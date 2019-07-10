package ru.kravchenko.tm.entity;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class Task extends AbstractEntity {

    @Nullable
    private Project project;

    @Nullable
    private String name = "";

    @Nullable
    private String description = "";

    @Override
    public String toString() {
        return "TASK NAME: \"" + this.name + "\" DESCRIPTION TASK: \"" + this.description + "\" " + "TASK ID: " +
                super.getId() + " PROJECT: " + this.project;
    }

}
