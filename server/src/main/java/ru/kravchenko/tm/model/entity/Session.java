package ru.kravchenko.tm.model.entity;

import com.sun.istack.internal.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jetbrains.annotations.NotNull;
import ru.kravchenko.tm.model.dto.SessionDTO;
import org.hibernate.annotations.Cache;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Roman Kravchenko
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "app_Session")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Session extends AbstractEntity {

    @ManyToOne
    private User user;

    @Nullable
    private String signature;

    @Nullable
    private Date timestamp;

    @Override
    public String toString() {
        return "Session{" +
                '\'' +
                ", signature='" + signature + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public SessionDTO getDTO() {
        @NotNull final SessionDTO dto = new SessionDTO();
        dto.setId(id);
        dto.setSignature(signature);
        dto.setTimestamp(timestamp);
        dto.setUserId(user.getId());
        return dto;
    }

}
