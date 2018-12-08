package com.assignment.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

    private final static String FILE_URL = "/testExamples/src/test/resources/test.data.properties";

    public static String getProperty(final String property) {
        Properties prop = new Properties();

        try (InputStream fileInputStream = new FileInputStream(FILE_URL)) {
            prop.load(fileInputStream);
            String result = prop.getProperty(property);
            if (result != null && !result.equals("")) {
                return result;
            }
        } catch (IOException ex) {
        }
        return "";
    }

}
