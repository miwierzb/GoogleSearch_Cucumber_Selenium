package com.assignment.core;

import java.util.HashMap;
import java.util.Map;

import static com.assignment.core.CustomLogger.logger;

public class SharedTestData {

    private static Map<String, String> sharedTestData = new HashMap<>();

    public void addData(String key, String value) {
        logger().info("Adding data to ShareTestData: KEY: " + key + ", VALUE: " + value);
        sharedTestData.put(key, value);
    }

    public String getData(String key) {
        if (sharedTestData.containsKey(key)) {
            String value = sharedTestData.get(key);
            logger().info("Getting data from ShareTestData. Returned VALUE: " + value + " for KEY: " + key);
            return sharedTestData.get(key);
        } else {
            throw new NullPointerException("KEY that you are looking for does NOT exist in SharedTestData");
        }
    }

}
