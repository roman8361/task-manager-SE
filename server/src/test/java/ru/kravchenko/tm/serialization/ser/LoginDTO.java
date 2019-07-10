package ru.kravchenko.tm.serialization.ser;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Roman Kravchenko
 */

@Getter
@Setter
@XmlRootElement
public class LoginDTO implements Serializable {

    @Nullable
    private String login;

    @Nullable
    private String password;

}
