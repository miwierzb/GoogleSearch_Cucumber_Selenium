package com.assignment.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.assignment.core.CustomLogger.logger;

public class PropertiesManager {

    private final static String FILE_URL = "/testExamples/src/test/resources/test.data.properties";

    public static String getProperty(final String property) {
        Properties prop = new Properties();

        try (InputStream fileInputStream = new FileInputStream(FILE_URL)) {
            prop.load(fileInputStream);
            String result = prop.getProperty(property);
            if (result != null && !result.equals("")) {
                logger().debug("Getting data from test properties file: " + property);
                return result;
            }
        } catch (IOException ex) {
            logger().error("Can not get data from properties file!", ex);
        }
        return "";
    }

}
