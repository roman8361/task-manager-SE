package ru.kravchenko.tm.test.level12.fromtm.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Config {

    private String driveName;

    private String databaseName;

    private String databaseType;

    private String host;

    private String username;

    private String password;

    private Integer port;


    @Override
    public String toString() {
        return "jdbc:" + databaseType + "://" + host + ":" + port + "/" + databaseName;
    }

}
