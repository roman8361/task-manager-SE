package ru.kravchenko.tm.entity;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.AbstractEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class Project extends AbstractEntity {

    @Nullable
    private String name;

    @Nullable
    private String description;

    public Project(@Nullable final String name) {this.name = name;}

    @Nullable
    private Date dateBegin;

    @Nullable
    private Date dateEnd;

    @NotNull
    private StatusProjectTask displayName = StatusProjectTask.PLANNED;

    @Override
    public String toString() {
        @NotNull final String pattern = "dd.MM.yyyy";
        @NotNull final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        @NotNull final String dateBering = simpleDateFormat.format(this.dateBegin);
        @NotNull final String dateEnd = simpleDateFormat.format(this.dateEnd);

        return "PROJECT NAME: \"" + this.name + "\" DESCRIPTION PROJECT: \"" + this.description + "\" "
                + "PROJECT ID: \"" + super.getId() + "\" DATE BEGIN: \"" + dateBering + "\" DATE END: \""
                + dateEnd + "\"" + " STATUS: " + this.displayName;
    }

}
