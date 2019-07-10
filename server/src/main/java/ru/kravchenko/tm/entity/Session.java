package ru.kravchenko.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.api.AbstractEntity;

import java.util.Date;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@NoArgsConstructor
public class Session extends AbstractEntity {

    @Nullable
    private String userId;

    @Nullable
    private String signature;

    @Nullable
    private Date timestamp;

    public Date getTimestampSql() {
        timestamp = new Date();
        java.sql.Date sqlDate = new java.sql.Date(timestamp.getTime());
        return sqlDate;
    }

    @Override
    public String toString() {
        return "Session{" +
                "userId='" + userId + '\'' +
                ", signature='" + signature + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

}
