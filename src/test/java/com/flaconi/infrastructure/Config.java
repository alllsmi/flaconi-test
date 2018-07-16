package com.flaconi.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Logger log = LoggerFactory.getLogger(Config.class);
    private static final String DEFAULT_PROPS_FILE_NAME = "testing.properties";
    private static ClassLoader classLoader = Config.class.getClassLoader();

    public static boolean isWindows;
    public static String landingUrl;

    static {
        Properties props = readPropertiesFile();
        isWindows = Boolean.parseBoolean(props.getProperty("isWindows"));
        landingUrl = props.getProperty("landingUrl");
    }

    private static Properties readPropertiesFile() {
        Properties props = new Properties();
        try (InputStream i = classLoader.getResourceAsStream(Config.DEFAULT_PROPS_FILE_NAME)) {
            props.load(i);
        } catch (IOException e) {
            log.info(e.getMessage(), e);
        }
        return props;
    }
}
