package ru.kravchenko.tm.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import ru.kravchenko.tm.model.entity.StatusProjectTask;

import java.util.Date;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class BaseEntityDTO extends AbstractEntityDTO {

    @Nullable
    protected Date dateBegin = new Date();

    @Nullable
    protected Date dateEnd = null;

    @Nullable
    protected String userId = "";

    @Getter
    protected StatusProjectTask status = StatusProjectTask.PLANNED;

}
