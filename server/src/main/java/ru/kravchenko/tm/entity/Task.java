package ru.kravchenko.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.AbstractEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class Task extends AbstractEntity implements Serializable {

    @Nullable
    private String projectId;

    @Nullable
    private String userId;

    @Nullable
    private String name;

    @Nullable
    private String description;

    @Nullable
    private Date dateBegin;

    @Nullable
    private Date dateEnd;

    public Date getDateBeginSql() {
        dateBegin = new Date();
        java.sql.Date sqlDate = new java.sql.Date(dateBegin.getTime());
        return sqlDate;
    }

    public Date getDateEndSql() {
        dateEnd = new Date();
        java.sql.Date sqlDate = new java.sql.Date(dateEnd.getTime());
        return sqlDate;
    }

    @NotNull
    private StatusProjectTask displayName = StatusProjectTask.PLANNED;

    @Override
    public String toString() {
        return "TASK NAME: \"" + this.name + "\" DESCRIPTION TASK: \"" + this.description + "\" " + "TASK ID: " +
                super.getId() + " PROJECT ID: " + projectId + " STATUS: " + this.displayName + " USER ID: " + userId;
    }

}
