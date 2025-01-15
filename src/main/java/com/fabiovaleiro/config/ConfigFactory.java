package com.fabiovaleiro.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFactory {
    private static Config config;

    public static Config getConfig(){

        if(config != null){
            return config;
        }

        Config config = new Config();
        Properties props = new Properties();
        try (InputStream input = ConfigFactory.class.getClassLoader().getResourceAsStream("db-config.properties")) {
            props.load(input);
            config.setDbUrl(props.getProperty("db.url"));
            config.setDbUser(props.getProperty("db.username"));
            config.setDbPassword(props.getProperty("db.password"));
        } catch ( IOException e) {
            throw new RuntimeException(e);
        }
        ConfigFactory.config = config;

        return config;
    }


}
