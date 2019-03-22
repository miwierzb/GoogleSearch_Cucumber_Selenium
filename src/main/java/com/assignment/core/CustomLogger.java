package com.assignment.core;

import org.apache.log4j.Logger;

public class CustomLogger {

    private static Logger logger;

    public static Logger logger() {
        if (logger == null) {
            logger = Logger.getLogger(CustomLogger.class);
            return logger;
        } else
            return logger;
    }

}
