package org.example.javafxfirst.constants;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class AppProperties {
    String rootPath = System.getProperty("user.dir");
    String appConfigPath = rootPath + "\\app.properties";
    Properties appProps = new Properties();

    public void checkFileExistsAndCreate() {
        File file = new File(appConfigPath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void updatePropertyArray(String property, String value, int maxLength) {
        String propertyValue = getProperty(property);

        // create new property if it doesn't exist
        if (propertyValue == null) {
            setProperty(property, value);
            return;
        }

        // add property to end of property list. Delete first element if list is full
        String newProperties = "";
        String[] propertyArrayString = propertyValue.split(",");
        int propertyArrayLength = propertyArrayString.length;

        if (propertyArrayString.length >= maxLength) {
            propertyArrayLength--;
        }
        for (int i = 0; i < propertyArrayLength; i++) {
            newProperties += "," + propertyArrayString[i];
        }

        // add new property value to start of property "array" (string)
        newProperties = value + newProperties;

        System.out.println("New props");
        System.out.println(newProperties);
        setProperty(property, newProperties);
    }

    public void setProperty(String property, String value) {
        Properties properties = getProperties();
        try (OutputStream output = new FileOutputStream(appConfigPath)) {
            properties.setProperty(property, value);
            properties.store(output, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }

    public String getProperty(String property) {
        checkFileExistsAndCreate();
        Properties properties = new Properties();
        String returnProperty = null;
        try {
            properties.load(new FileInputStream(appConfigPath));
            returnProperty = properties.getProperty(property);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return returnProperty;
    }

    public String[] getPropertyAsArray(String property) {
        String[] propertyArray;
        String propertyRes = getProperty(property);

        if (propertyRes == null) {
            propertyArray = new String[]{};
        } else {
            propertyArray = propertyRes.split(",");
        }


        return propertyArray;
    }
}
