package project.service;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = PropertyResourceBundle
            .getBundle(System.getProperty("environment"));

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
