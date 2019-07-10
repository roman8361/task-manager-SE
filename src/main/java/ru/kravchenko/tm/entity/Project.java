package ru.kravchenko.tm.entity;

import lombok.Getter;
import lombok.Setter;
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

    @Override
    public String toString() {
        String pattern = "dd.MM.yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateBering = simpleDateFormat.format(this.dateBegin);
        String dateEnd = simpleDateFormat.format(this.dateEnd);

        return "PROJECT NAME: \"" + this.name + "\" DESCRIPTION PROJECT: \"" + this.description + "\" "
                + "PROJECT ID: \"" + super.getId() + "\" DATE BEGIN: \"" + dateBering + "\" DATE END: \""
                + dateEnd + "\"";
    }

}
