package ru.kravchenko.tm.collection.compatator;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
public class Town implements Comparable {

    @NotNull
    private final String name;

    @NotNull
    private final Integer count;

    public Town(@NotNull final String name, @NotNull final Integer count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(@NotNull final Object o) {
        @NotNull final Town town = (Town) o;
        return count.compareTo(town.count);
    }

}
