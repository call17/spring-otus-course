package ru.otus.homework1.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;

import java.util.Locale;

@ConfigurationProperties
public class YamlProps {

    @Autowired
    private Environment environment;

    public String getMessage(String code){
        String localeCode = Locale.getDefault().toLanguageTag();
        switch (localeCode){
            case "ru":
                return this.environment.getProperty("ru." + code);
            case "en":
                return this.environment.getProperty("en." + code);
                default:
                    System.out.println(localeCode);
                    throw new RuntimeException("Unexpected locale code");
        }
    }
}


