package ru.home.sql;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider {
    private static final Properties appProperties = new Properties();
    static {
        try {
            appProperties.load(new FileInputStream("src/main/resources/application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Properties getAppProperties(){
        return new Properties(appProperties); //Defence copy, изменяя ее, исходный файл не будет изменяться
    }
}